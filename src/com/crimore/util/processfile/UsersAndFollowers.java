package com.crimore.util.processfile;

import com.crimore.domain.UserAccount;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by cchingwenje on 2015-08-23.
 */
public class UsersAndFollowers {

    /**
     *
     * @param usersFile
     * @return Set<UserAccount>
     * @comment returns a set of users and their followers
     */
    public static Set<UserAccount> createUserAccountsAndFollowers(File usersFile) {
        BufferedReader br = null;
        Set<UserAccount> listOfUserAccountsBeingFollowed = new TreeSet<UserAccount>();
        try {
            FileInputStream fis = new FileInputStream(usersFile);
            DataInputStream dis = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(dis, Charset.forName("US-ASCII")));

            String line = null;
            String listOfFollowedUsers = "";
            UserAccount userFollowingSomeUserAccount = new UserAccount(); // create userBeingFollowed following someUser
            while ((line = br.readLine()) != null) {

                int indexOfFollows = line.indexOf("follows");

                String nameOfUserFollowingSomeUser = line.substring(0, indexOfFollows).trim(); // get name of user being followed (get Ward from "Ward follows Alan")

                userFollowingSomeUserAccount.setName(nameOfUserFollowingSomeUser);

                listOfFollowedUsers = line.substring(indexOfFollows + 7); // get list as string eg "Martin,Alan"

                String[] arrayOfFollowedUsers = null;
                if (listOfFollowedUsers.indexOf(",") != -1) {
                    arrayOfFollowedUsers = listOfFollowedUsers.split(",");  // if line eg = "Martin,Alan"
                } else {
                    arrayOfFollowedUsers = new String[]{listOfFollowedUsers.trim()}; // if line eg = "Martin"
                }

                Set<UserAccount> setOfUserFollowingSomeUser = null;
                UserAccount userBeingFollowed = null;
                for (String arrayOfFollowedUser : arrayOfFollowedUsers) {

                    userBeingFollowed = new UserAccount();
                    userBeingFollowed.setName(arrayOfFollowedUser.trim());

                    UserAccount userFollowingSomeUser = new UserAccount();
                    userFollowingSomeUser.setName(nameOfUserFollowingSomeUser.trim());

                    setOfUserFollowingSomeUser = new TreeSet<UserAccount>();
                    setOfUserFollowingSomeUser.add(userFollowingSomeUser);

                    userBeingFollowed.setFollowers((TreeSet<UserAccount>) setOfUserFollowingSomeUser);

                    listOfUserAccountsBeingFollowed.add(userBeingFollowed);
                }

                listOfUserAccountsBeingFollowed.add(userFollowingSomeUserAccount); // add follower as a user
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return listOfUserAccountsBeingFollowed;
    }
}
