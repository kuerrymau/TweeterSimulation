package com.allangray.util.processfile;

import com.allangray.domain.Tweet;
import com.allangray.domain.User;
import com.google.common.collect.HashBasedTable;

import java.io.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by cchingwenje on 2015-08-23.
 */
public class ProcessUsersAndFollowers{
    /**
     *
     * @param usersFile
     * @return HashBasedTable containing user, followers and user tweets
     * @comment
     */
    public static HashBasedTable<User, Set<User>, ArrayList<Tweet>> getUserAndFollowersFromFile(File usersFile) {
        System.out.println("ProcessUsersAndFollowers.getUserAndFollowersFromFile()");
        BufferedReader br = null;

        HashBasedTable<User, Set<User>, ArrayList<Tweet>> userFollowersAndTweets = HashBasedTable.create();
        try {
            FileInputStream fis = new FileInputStream(usersFile); // FIXME get file path
            DataInputStream dis = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(dis));

            String line = null;
            String nameBeingFollowed = "";
            while ((line = br.readLine()) != null) {

                int indexOfFollows = line.indexOf("follows");

                String nameOfUserFollowingSomeUser = line.substring(0, indexOfFollows); // get name of user being followed

                User userFollowingSomeUser = new User();
                userFollowingSomeUser.setName(nameOfUserFollowingSomeUser);

                Set<User> setOfFollowers = new TreeSet<User>(new User.UserComparator());

                User userBeingFollowed = null;

                String listOfFollowedUsers = line.substring(indexOfFollows + 7); // get list as string eg "Martin,Alan"

                StringTokenizer stringTokenizer = new StringTokenizer(listOfFollowedUsers, ",");

                while (stringTokenizer.hasMoreTokens()) {
                    nameBeingFollowed = stringTokenizer.nextToken(); // get name of follower

                    userBeingFollowed = new User();
                    userBeingFollowed.setName(nameBeingFollowed);

                    setOfFollowers.add(userFollowingSomeUser); // add follower to list

                    userFollowersAndTweets.put(userBeingFollowed, setOfFollowers, new ArrayList<Tweet>()); // add user and followers and place holder for tweets to hash table
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (Exception ex) {
            }
        }
        return userFollowersAndTweets;
    }
}
