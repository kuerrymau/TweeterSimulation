package com.crimore.main;

import com.crimore.util.processfile.UserAndTweets;
import com.crimore.util.processfile.UsersAndFollowers;
import com.crimore.util.processfile.process.ProcessUsersFollowersAndTweets;

import java.io.File;

public class Main {
    /**
     * @comment gets files from command line or "IDE" arguments
     * @param args
     */
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

            ProcessUsersFollowersAndTweets.processUsersFollowersAndTweets(UsersAndFollowers.createUserAccountsAndFollowers(usersFile),
                                                    UserAndTweets.processUsersAndTweets(tweetsFile));

        }
    }
}