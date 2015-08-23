package com.allangray.main;

import com.allangray.domain.Tweet;
import com.allangray.domain.User;
import com.allangray.util.processfile.ProcessTweets;
import com.allangray.util.processfile.ProcessUsersAndFollowers;
import com.google.common.collect.HashBasedTable;

import java.io.File;
import java.util.ArrayList;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Please supply a users file and a tweets file:" + args.length);
            System.exit(0);
        } else if (args.length == 1) {
            System.err.println("Please supply tweets file:" + args.length);
            System.exit(0);
        } else {
            System.out.println("args[0]=" + args[0]);
            System.out.println("args[1]=" + args[1]);
            File usersFile = new File(args[0]);
            File tweetsFile = new File(args[1]);
            HashBasedTable<User, Set<User>, ArrayList<Tweet>> userAndFollowersFromFile = (HashBasedTable<User, Set<User>, ArrayList<Tweet>>) ProcessUsersAndFollowers.getUserAndFollowersFromFile(
                    usersFile);

            HashBasedTable<User, Set<User>, ArrayList<Tweet>> userSetArrayListHashBasedTable = ProcessTweets.processUsersAndTweets(
                    userAndFollowersFromFile,
                    tweetsFile);
        }
    }
}