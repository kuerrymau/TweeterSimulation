package com.crimore.domain;

import java.util.Objects;
import java.util.TreeSet;

/**
 * Created by cchingwenje on 2015-08-23.
 */
public class UserAccount  implements Comparable<UserAccount> {
    private String name;
    private TreeSet<UserAccount> followers;


    public UserAccount() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFollowers(TreeSet<UserAccount> followers) {
        this.followers = followers;
    }

    public TreeSet<UserAccount> getFollowers() {
        return followers;
    }

    public UserAccount createUser(UserAccount u, String name){
        u.setName(name);
        return u;
    }

    @Override
    public int compareTo(UserAccount o1) {
        return this.getName().compareTo(o1.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccount)) return false;
        UserAccount userAccount = (UserAccount) o;
        return Objects.equals(this.name, userAccount.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
