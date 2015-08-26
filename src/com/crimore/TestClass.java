package com.crimore;

import com.crimore.util.processfile.UserAndTweets;
import com.crimore.util.processfile.UsersAndFollowers;
import com.crimore.util.processfile.process.ProcessUsersFollowersAndTweets;
//import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cchingwenje on 2015-08-23.
 */
@Deprecated // not used
public class TestClass {

//    @Test
    public void canViewUserAndFollowers() {
        ProcessUsersFollowersAndTweets.processUsersFollowersAndTweets(UsersAndFollowers.
                                                                              createUserAccountsAndFollowers(getInputFiles().get(0)),
                                                                                 UserAndTweets.processUsersAndTweets(getInputFiles().get(1)));
    }

    private List<File> getInputFiles() {
        String[] args = {};
        List<File> inputFiles = new ArrayList<File>();
        if (args.length < 1) {
            System.err.println("Please supply a users file and a tweets file:" + args.length);
            System.exit(0);
        } else if (args.length == 1) {
            System.err.println("Please supply tweets file:" + args.length);
            System.exit(0);
        } else {
            inputFiles.add(new File(args[0]));
            inputFiles.add(new File(args[1]));
        }
        return inputFiles;
    }
}
