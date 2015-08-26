package com.crimore.util.processfile.process;

import com.crimore.domain.Tweet;
import com.crimore.domain.UserAccount;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by cchingwenje on 2015-08-23.
 */
public class ProcessUsersFollowersAndTweets {

    /**
     * @param userAccountsAndFollowers
     * @param tweets
     * @return HashBasedTable<UserAccount, Set<UserAccount>, ArrayList<Tweet>>
     * @comment creates final store of users, followers and the tweets and print to stdout
     */
    public static void processUsersFollowersAndTweets(Set<UserAccount> userAccountsAndFollowers,
                                                      ArrayList<Tweet> tweets) {
        System.out.println("in ProcessUsersFollowersAndTweets.processUsersFollowersAndTweets()"); // FIXME use log4j

        ArrayList<Tweet> listOfTweets = null;

        for (UserAccount userAccount : userAccountsAndFollowers) { // merge users and their tweets
            listOfTweets = new ArrayList<Tweet>();
            for (Tweet tweet : tweets) {
                if (userAccount.equals(tweet.getUserAccount())) {
                    listOfTweets.add(tweet);
                }
            }
           System.out.println(userAccount.getName());
            for(Tweet twee: listOfTweets) {
                System.out.println("@" + userAccount.getName() + ": " + twee.getTweet());
            }
        }
    }
}
