package com.crimore.util.processfile;

import com.crimore.domain.Tweet;
import com.crimore.domain.UserAccount;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by cchingwenje on 2015-08-23.
 */
public class UserAndTweets {

    /**
     *
     * @param tweetsFile
     * @return ArrayList<Tweet>
     * @comment grabs Users and TweetStrings from file to create Tweet objects
     */
    public static ArrayList<Tweet> processUsersAndTweets(File tweetsFile) {

        BufferedReader br = null;

        ArrayList<Tweet> listOfTweets = null;
        try {
            FileInputStream fis = new FileInputStream(tweetsFile);
            DataInputStream dis = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(dis, Charset.forName("US-ASCII")));

            listOfTweets = new ArrayList<Tweet>();
            String nameOfTweetOwner = "";
            String tweetString = "";

            String line = "";
            while ((line = br.readLine()) != null) {
                line = line.trim();
                int indexOfGreaterSign = line.indexOf(">");
                nameOfTweetOwner = line.substring(0, indexOfGreaterSign).trim(); // nameOfTweetOwner = substring to ">"
                tweetString = line.substring(indexOfGreaterSign + 2, line.length()); // tweetString = substring from ">" to enf of line

                if (tweetString.length() > 140) { // check if tweet is longer than 140 chars
                    System.err.println("Please supply a tweet that is <= 140 characters");
                    System.exit(0);
                } else {
                    tweetString = tweetString.substring(0, tweetString.length());
                }

                UserAccount tweetOwner = new UserAccount();
                tweetOwner.setName(nameOfTweetOwner);

                listOfTweets.add(new Tweet(tweetOwner, tweetString));
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
        return listOfTweets;
    }
}
