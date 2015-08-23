package com.allangray.domain;

/**
 * Created by cchingwenje on 2015-08-23.
 */
public class Tweet {
    private User user;
    private String tweet;

    public Tweet() {
    }

    public Tweet(User user) {
        this.user = user;
    }

    public Tweet(User user, String tweet) {
        this.user = user;
        this.tweet = tweet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public Tweet createTweet(Tweet t, User u, String s){
        t.setUser(u);
        t.setTweet(s);
        return t;
    }
}
