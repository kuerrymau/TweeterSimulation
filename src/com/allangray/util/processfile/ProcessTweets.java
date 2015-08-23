package com.allangray.util.processfile;

import com.allangray.domain.Tweet;
import com.allangray.domain.User;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by cchingwenje on 2015-08-23.
 */
public class ProcessTweets {
    User user = new User();
    Tweet tweet = new Tweet();

    public static HashBasedTable<User, Set<User>, ArrayList<Tweet>> processUsersAndTweets(HashBasedTable<User, Set<User>, ArrayList<Tweet>> userAndFollowers,
                                                                                          File tweetsFile) {
        System.out.println("ProcessTweets.processUsersAndTweets()");

        BufferedReader br = null;

        try {
            FileInputStream fis = new FileInputStream(tweetsFile);
            DataInputStream dis = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(dis));

            String line = "";

            ArrayList<Tweet> tweets = new ArrayList<Tweet>();
            String nameOfTweetOwner = "";
            for (Table.Cell<User, Set<User>, ArrayList<Tweet>> cell : userAndFollowers.cellSet()) {
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    int indexOfGreaterSign = line.indexOf(">");
                    nameOfTweetOwner = line.substring(0, indexOfGreaterSign);
                    line = line.substring(indexOfGreaterSign, line.length());

                    User tweetOwner = new User();
                    tweetOwner = tweetOwner.createUser(tweetOwner, nameOfTweetOwner);

                    if (line.length() <= 140) { // check if tweet is longer than 140 chars
                        // FIXME add warning message
                    } else {
                        line = line.substring(0, 140); // trim tweet
                    }
                    User rowKey = cell.getRowKey();
                    System.out.println("cell.getRowKey()=" + rowKey.getName().trim() + ", tweetOwner=" + tweetOwner.getName());
                    if (rowKey.getName().trim().equals(tweetOwner.getName().trim())) {

                        Tweet tweet = new Tweet();
                        tweet = tweet.createTweet(tweet, tweetOwner, line);
                        tweets.add(tweet);

                        userAndFollowers.row(rowKey).put(cell.getColumnKey(),
                                                                   tweets); // add tweets to user (using) followers

                    }
                }
            }

            for (User key : userAndFollowers.rowKeySet()) {

                String userName = key.getName();
                System.out.println(userName);
                for (Table.Cell<User, Set<User>, ArrayList<Tweet>> cell : userAndFollowers.cellSet()) {
                    if (cell.getValue() != null && cell.getValue().size() > 0) {
                        System.out.println("@" + cell.getRowKey().getName().trim() + ": " + cell.getColumnKey() + ": " + cell.getValue());
                    }

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

        return userAndFollowers;
    }
}
