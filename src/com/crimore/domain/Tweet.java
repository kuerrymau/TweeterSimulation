package com.crimore.domain;

/**
 * Created by cchingwenje on 2015-08-23.
 */
public class Tweet {
    private UserAccount userAccount;
    private String tweet;

    public Tweet() {
    }

    public Tweet(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Tweet(UserAccount userAccount, String tweet) {
        this.userAccount = userAccount;
        this.tweet = tweet;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public Tweet createTweet(Tweet t, UserAccount u, String s){
        t.setUserAccount(u);
        t.setTweet(s);
        return t;
    }
}
