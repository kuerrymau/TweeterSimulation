Small java application to simulate time lines tweeter feeds for users.

To run copy zip file to C drive and ununzip and configure arguments in IDE (Eclipse and IntelliJ) if running the app using an IDE.

If running the app using command line copy the following commands and paste in windows cmd and execute

javac -d TweeterSimulation\build -cp lib\guava-18.0.jar;lib\junit-4.10.jar TweeterSimulation\src\com\crimore\domain\UserAccount.java TweeterSimulation\src\com\crimore\domain\Tweet.java TweeterSimulation\src\com\crimore\util\processfile\UserAndTweets.java TweeterSimulation\src\com\crimore\util\processfile\GetBufferedReader.java TweeterSimulation\src\com\crimore\util\processfile\process\ProcessUsersFollowersAndTweets.java TweeterSimulation\src\com\crimore\util\processfile\UsersAndFollowers.java TweeterSimulation\src\com\crimore\main\Main.java

then execute:

java -jar -cp lib\guava-18.0.jar;lib\junit-4.10.jar TweeterSimulation\build\com\crimore\main\Main TweeterSimulation\resources\user.txt TweeterSimulation\resources\tweet.txt


