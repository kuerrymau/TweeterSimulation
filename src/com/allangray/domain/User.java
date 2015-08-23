package com.allangray.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Created by cchingwenje on 2015-08-23.
 */
public class User {
    private String name;
    List<User> followers;


    public User() {

    }

    public User(String follower) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public User createUser(User u, String name){
        u.setName(name);
        return u;
    }

    public static class UserComparator implements Comparator<User>{
        @Override
        public int compare(User o1, User o2) {
            if(o1.getName().equals(o2.getName())) {
                return 0;
            }
            return -1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

//////////****************************TESTS**************************//////////////

//@Test
////    @RunWith(Parameterised.class)
//    public void test (){
//        Table<User, Set<User>, ArrayList<Tweet>> userSetArrayListTable = testUserAndFollowers();
//        usersAndTweets(userSetArrayListTable);
//    }
//    private Table<User, Set<User>, ArrayList<Tweet>> testUserAndFollowers() {
//        String line = "";
//        // Ward follows Martin,Alan
//         line = "Alan follows Martin,Ward, Chipo,       Andrew";
//////        String user = ward.substring(0, ward.indexOf("follows"));
////        int indexOfFollows = line.indexOf("follows");
////        System.out.println("indexOfFollows=" + indexOfFollows + 6);
////        String follows = line.substring(indexOfFollows + 7);
////        System.out.println("follows=" + follows.trim());
//
//        Table<User, Set<User>, ArrayList<Tweet>> userFollowersAndTweets = HashBasedTable.create();
//
//        String followerName = "";
//        String followers = line.substring(line.indexOf("follows") + 7);
//        StringTokenizer st = new StringTokenizer(followers, ",");
//        Set<User> listOfFollowers = new TreeSet<User>(new UserComparator());
//
//        while (st.hasMoreTokens()) {
//            followerName = st.nextToken();
//
////            System.out.println("follower: " + follower);
//            User user = new User();
//            user.setName(followerName.trim());
//
//            listOfFollowers.add(user);
//        }
//        String username = line.substring(0, line.indexOf("follows"));
//        User user = new User();
//        user.setName(username.trim());
//
//        userFollowersAndTweets.put(user, listOfFollowers, new ArrayList<Tweet>());
//
//        for (String key : userFollowersAndTweets.rowKeySet()) {
//
//           System.out.println("User: " + key);
//
//            for (Map.Entry<Set<User>, ArrayList<String>> row: userFollowersAndTweets.row(key).entrySet()) {
//                Iterator<User> iterator = row.getKey().iterator();
//                while(iterator.hasNext()){
//                    User user = (User) iterator.next();
//                    System.out.println("follower= " + user.getName());}
////                System.out.println("tweets= " + row.getValue().iterator().next());
//            }
//        }
//        return userFollowersAndTweets;
//    }
//
//    private void usersAndTweets(Table<User, Set<User>, ArrayList<Tweet>> userFollowersAndTweets){
//        String line = "Alan> If you have a procedure with 10 parameters, you probably missed some.";
//
//        String userName = line.substring(0, line.indexOf(">"));
//        Set<User> listOfLines = new TreeSet<User>(new UserComparator());
//
////        while (st.hasMoreTokens()) {
//            line = line.trim();
//            if(!"".equals(line)){
//                for(User user :userFollowersAndTweets.rowKeySet()){
//                    System.out.println("user=" + user.getName());
//                    if( user.getName().equalsIgnoreCase(userName)){
//                        User myUser = new User();
//                        myUser.setName(userName);
//                        System.out.println("use with tweets= " + myUser.getName());
//                        ArrayList<Tweet> tweets = new ArrayList<Tweet>();
//
//                        Tweet tweet = new Tweet();
//                        tweet.setUser(myUser);
//                        tweet.setTweet(line);
//                        tweets.add(tweet);
//
//                        userFollowersAndTweets.row(myUser).put(userFollowersAndTweets.rowKeySet(), tweets);
//                    }
//                }
//            }
//
//        for (User key : userFollowersAndTweets.rowKeySet()) {
//
//           System.out.println("User: " + key.getName());
//
//            for (Map.Entry<Set<User>, ArrayList<Tweet>> row: userFollowersAndTweets.row(key).entrySet()) {
//                Iterator<User> iterator = row.getKey().iterator();
//                while(iterator.hasNext()){
//                    User user = (User) iterator.next();
//                }
//                ArrayList<Tweet> tweets = row.getValue();
//                if(tweets.size() > 0) {
//                    Tweet tweet = (Tweet) tweets.iterator().next();
//                    System.out.println("tweet= " + tweet.getTweet());
//                }
//            }
//        }
//    }
}
