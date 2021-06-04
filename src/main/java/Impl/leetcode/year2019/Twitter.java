package main.java.Impl.leetcode.year2019;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javafx.util.Pair;

public class Twitter {

    Integer TWEET_TIME = Integer.MIN_VALUE;
    Graph graph;

    Comparator<Tweet> comparator = new Comparator<Tweet>()
    {
        @Override
        public int compare(Tweet o1, Tweet o2) {
            return o2.tweetTime - o1.tweetTime;
        }
    };

    /** Initialize your data structure here. */
    public Twitter() {
        graph = new Graph();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        // add node to followersList if it doesn't exists
        addItemToFollowersList(graph, userId);
        // add node to followeeList if it doesn't exists
        addItemToFolloweeList(graph, userId);

        Tweet newTweet = new Tweet();
        newTweet.setTweetId(tweetId);
        newTweet.setTweetTime(++TWEET_TIME);
        newTweet.setUserId(userId);
        postAndRecoincileTweet(graph, userId, newTweet);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        int count = 10;
        if (graph.tweets.containsKey(userId)) {
            for(Tweet t : graph.tweets.get(userId)) {
                if(count <= 0) {
                    break;
                }
                result.add(t.tweetId);
                count--;
            }
        }
        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            follow(graph, followerId, followeeId);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            unfollow(graph, followerId, followeeId);
            deleteAndRecoincileTweet(graph, followerId, followeeId);
        }
    }

    public static class Graph {
        Map<Integer, Set<Integer>> followers = null;
        Map<Integer, Set<Integer>> followees = null;
        Map<Integer, Set<Tweet>> tweets = null;

        Graph() {
            followers = new HashMap<>();
            followees = new HashMap<>();
            tweets  = new HashMap<>();
        }
    }

    private void postAndRecoincileTweet(Graph graph, Integer userId, Tweet t1) {

        for (Integer otherUser : graph.followees.get(userId)) {
            Set<Integer> allowedUser = new HashSet<>();
            Set<Tweet> tweetSet = new TreeSet<>(comparator);
            for (Integer subUser : graph.followers.get(otherUser)) {
                // add the tweet
                tweetSet.add(t1);
                allowedUser.add(subUser);
                if (graph.tweets.get(subUser) != null) {
                    tweetSet.addAll(graph.tweets.get(subUser));
                }
            }
            graph.tweets.put(otherUser, filterTweetsBasedOnAllowedUser(allowedUser, tweetSet));
        }
    }

    private void recoincileTweet(Graph graph, Integer userId) {

        for (Integer otherUser : graph.followees.getOrDefault(userId, new HashSet<>())) {
            Set<Integer> allowedUser = new HashSet<>();
            Set<Tweet> tweetSet = new TreeSet<>(comparator);
            for (Integer subUser : graph.followers.getOrDefault(otherUser, new HashSet<>())) {
                allowedUser.add(subUser);
                if (graph.tweets.get(subUser) != null) {
                    tweetSet.addAll(graph.tweets.get(subUser));
                }
            }
            graph.tweets.put(otherUser, filterTweetsBasedOnAllowedUser(allowedUser, tweetSet));
        }
    }

    private void deleteAndRecoincileTweet(Graph graph, Integer followerId, Integer followeeId) {
        Set<Integer> allowedUser = new HashSet<>();
        Set<Tweet> tweetSet = new TreeSet<>(comparator);
        if(graph.tweets.get(followerId) == null) {
            allowedUser.add(followerId);
        }
        for (Integer otherUser : graph.followees.getOrDefault(followerId, new HashSet<>())) {
            if (graph.tweets.get(otherUser) != null) {
                tweetSet.addAll(graph.tweets.get(otherUser));
                allowedUser.add(otherUser);
            }
        }
        allowedUser.remove(followeeId);
        graph.tweets.put(followerId, filterTweetsBasedOnAllowedUser(allowedUser, tweetSet));
    }

    private Set<Tweet> filterTweetsBasedOnAllowedUser(Set<Integer> allowedUser, Set<Tweet> tweetSet) {
        Set<Tweet> result = new TreeSet<Tweet>(comparator);
        for (Tweet t : tweetSet) {
            if (allowedUser.contains(t.userId)) {
                result.add(t);
            }
        }
        return result;
        //        return tweetSet.stream().filter(s -> !allowedUser.contains(s.tweetId)).collect(Collectors.toCollection(TreeSet::new));
    }

    private void follow(Graph graph, int src, int dest) {
        // let's say A->B, then A - A,B
        addItemToFollowersList(graph, src);
        addItemToFollowersList(graph, dest);
        graph.followers.get(src).add(dest);

        // let's say A->B, then this followee should have B - B,A
        addItemToFolloweeList(graph, src);
        addItemToFolloweeList(graph, dest);
        graph.followees.get(dest).add(src);

        // lets sync tweets
        recoincileTweet(graph, src);
        recoincileTweet(graph, dest);

    }

    private void unfollow(Graph graph, int src, int dest) {
        if(graph.followers.get(src) == null) {
            addItemToFollowersList(graph, src);
        }
        if(graph.followees.get(dest) == null) {
            addItemToFolloweeList(graph, dest);
        }
        graph.followers.get(src).remove(dest);
        graph.followees.get(dest).remove(src);

        // lets sync tweets
        recoincileTweet(graph, src);
        recoincileTweet(graph, dest);
    }

    private void addItemToFollowersList(Graph graph, int src) {
        if(graph.followers.get(src) == null) {
            HashSet<Integer> followersList = new HashSet<>();
            followersList.add(src);
            graph.followers.put(src, followersList);
        }
    }

    private void addItemToFolloweeList(Graph graph, int src) {
        if(graph.followees.get(src) == null) {
            HashSet<Integer> followeesList = new HashSet<>();
            followeesList.add(src);
            graph.followees.put(src, followeesList);
        }
    }

    public static class Tweet {
        Integer tweetId ;
        Integer tweetTime ;
        Integer userId;

        Tweet() {
        }

        void setTweetTime(Integer tweetTime) {
            this.tweetTime = tweetTime;
        }

        Integer getTweetTime() {
            return tweetTime;
        }

        void setTweetId(Integer tweetId) {
            this.tweetId = tweetId;
        }

        Integer getTweetId() {
            return tweetId;
        }

        void setUserId(Integer userId) {
            this.userId = userId;
        }

        Integer getUserId() {
            return userId;
        }
    }

    public static void main(String[] args) {
        String[] action = {"Twitter","postTweet","unfollow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","unfollow","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","unfollow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","unfollow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","unfollow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","follow","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","unfollow","postTweet","follow","postTweet","follow","postTweet","postTweet","unfollow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","unfollow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","unfollow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","unfollow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","unfollow","postTweet","postTweet","follow","postTweet","unfollow","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","unfollow","postTweet","postTweet","postTweet","unfollow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","unfollow","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","unfollow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","unfollow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","unfollow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","unfollow","postTweet","postTweet","postTweet","postTweet","follow","postTweet","follow","postTweet","postTweet","postTweet","postTweet","unfollow","postTweet","follow","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","follow","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","unfollow","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","unfollow","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","follow","postTweet","unfollow","postTweet","getNewsFeed","getNewsFeed","getNewsFeed","getNewsFeed","getNewsFeed","getNewsFeed","getNewsFeed","getNewsFeed","getNewsFeed","getNewsFeed"};
        int[][] value = {{},{3,9998},{7,10},{9,4395},{1,1201},{5,1977},{3,8997},{9,3526},{9,5593},{5,2318},{1,2961},{5,4269},{5,2441},{2,594},{1,2717},{1,6755},{1,9059},{7,4017},{7,645},{8,9472},{7,8607},{5,403},{4,1789},{4,2254},{4,5008},{8,6724},{1,6634},{8,8552},{9,3813},{9,1522},{1,7601},{1,3368},{5,1},{9,5149},{4,4368},{5,9131},{1,703},{9,4365},{2,3},{5,9729},{5,4},{7,7733},{8,5686},{1,2108},{9,2292},{1,8801},{7,7672},{7,8991},{9,1684},{8,5},{5,5858},{5,7989},{7,1027},{3,6949},{3,9501},{1,9116},{6,2},{4,2816},{7,5132},{1,6458},{9,5835},{7,9409},{8,5930},{8,8111},{4,8602},{6,9},{3,8234},{5,5627},{8,22},{3,3510},{8,4810},{3,9742},{10,4010},{5,6869},{3,7768},{4,6774},{3,1471},{7,6123},{1,5},{2,6356},{8,692},{1,3965},{1,8290},{9,3117},{2,3675},{4,3},{4,4033},{2,2725},{8,3698},{9,4326},{3,5351},{3,4897},{5,5549},{9,10},{8,8468},{5,754},{3,6988},{3,4360},{8,8755},{7,6670},{3,8910},{7,6},{7,6760},{1,2},{4,5977},{9,3087},{3,5},{7,8251},{9,5892},{5,3214},{3,9265},{7,8750},{3,3089},{1,9847},{8,479},{3,8519},{3,8960},{8,5},{2,7937},{1,3},{7,3833},{7,6},{3,4340},{7,3969},{1,7},{5,7559},{9,2369},{3,8007},{9,2221},{5,781},{4,3659},{2,3097},{8,539},{7,7639},{9,2928},{1,4187},{1,6},{10,7403},{7,3851},{7,8496},{3,1926},{1,6203},{1,4858},{1,1851},{5,286},{8,7446},{9,462},{9,5},{9,4659},{7,7716},{3,8},{4,7450},{5,2446},{9,9220},{10,2597},{3,1904},{9,509},{3,3210},{3,1737},{5,7753},{5,4703},{1,3865},{4,3665},{9,5105},{9,9955},{8,1957},{1,3412},{7,9823},{3,1916},{8,6610},{4,7397},{1,3814},{8,4513},{5,3236},{3,4661},{4,6978},{5,5320},{7,9799},{4,8326},{7,10},{8,9786},{3,2619},{5,9925},{9,6691},{4,1129},{7,3158},{1,9812},{3,7586},{3,4451},{1,3286},{9,6386},{7,2332},{5,7724},{3,2655},{5,7932},{7,4627},{2,4690},{5,1571},{1,4547},{7,1355},{5,5579},{9,2650},{4,2992},{2,6103},{8,4980},{4,6797},{4,4214},{9,1},{4,7496},{9,369},{9,772},{2,3610},{8,6339},{1,5107},{3,1},{5,7253},{3,3425},{7,8312},{1,9883},{2,548},{8,8550},{4,7139},{4,5222},{4,3},{3,2059},{9,6747},{7,9804},{7,450},{5,2338},{5,688},{8,3953},{10,8880},{3,9453},{8,9530},{5,2179},{5,3901},{5,9643},{1,864},{7,4736},{9,4670},{1,2},{5,6004},{2,7799},{1,7491},{9,1496},{9,3299},{7,9332},{5,7659},{3,2470},{9,2511},{4,2},{7,2666},{4,6620},{7,6239},{9,5271},{2,4345},{2,6},{1,7117},{3,2624},{4,1114},{7,4836},{2,1998},{3,9839},{5,792},{4,1668},{7,9455},{10,7654},{4,10},{7,266},{7,2708},{7,8},{2,4246},{5,1},{9,6449},{9,6377},{5,4909},{6,1},{1,4946},{4,8542},{3,3680},{9,3340},{4,2682},{7,9802},{3,306},{5,3348},{8,3537},{9,8},{8,6272},{4,1976},{1,7928},{5,4827},{1,4510},{2,6226},{4,9659},{9,4905},{5,8},{2,7113},{3,6523},{9,701},{4,823},{9,3349},{7,7539},{3,2},{8,5387},{4,8268},{5,2192},{5,2488},{5,5294},{9,3496},{7,2799},{1,868},{5,1761},{4,5},{2,5706},{1,1642},{1,1579},{3,2397},{5,5725},{4,4711},{5,2837},{10,3975},{9,5979},{5,9413},{9,8252},{7,3314},{7,8300},{3,8932},{1,8032},{9,6821},{9,6643},{7,928},{2,5044},{3,1046},{8,2058},{2,8},{4,1051},{8,4492},{8,9326},{8,3022},{8,2},{5,7320},{1,6837},{5,7636},{1,2085},{9,7},{3,8184},{4,1719},{1,6365},{9,6834},{4,4},{1,3240},{3,4966},{3,56},{1,6},{3,77},{3,5898},{5,1495},{9,8368},{9,7650},{7,6256},{1,9721},{1,4537},{2,7957},{7,3970},{1,964},{5,4473},{7,5953},{1,164},{5,2},{5,3940},{1,2010},{5,5635},{9,7708},{1,1801},{3,4361},{3,5708},{4,4099},{8,1},{3,6311},{9,7},{9,4636},{1,3116},{5,5113},{4,9348},{3,9164},{8,4484},{5,3956},{10,5243},{7,4316},{1,7889},{10,7817},{9,5546},{5,7987},{2,9738},{4,4588},{3,2406},{2,1321},{5,4883},{5,5342},{8,499},{3,8039},{2,8141},{7,3069},{7,2887},{8,5811},{5,1340},{3,2023},{1,5495},{9,6885},{8,3730},{9,2817},{10,8427},{5,2},{4,577},{9,7587},{6,8736},{1,6878},{10,5},{8,6887},{7,910},{5,7207},{1,8},{3,9138},{5,7},{8,9886},{8,8975},{9,8812},{4,886},{8,6504},{10,4},{1,8205},{9,3697},{7,6371},{5,8010},{4,5810},{7,7362},{2,5949},{4,8819},{4,6},{4,2841},{8,3708},{1,6},{3,8713},{9,5449},{9,9517},{3,9191},{5,9619},{7,5073},{1,2290},{2,8482},{6,9},{5,6432},{9,736},{2,6566},{4,4658},{8,420},{3,9037},{5,9728},{5,8661},{3,9},{5,9935},{8,4240},{2,1965},{1,4655},{8,6251},{9,5927},{8,9853},{9,5},{9,6927},{1,4577},{10,639},{5,817},{7,7913},{7,4},{5,9227},{8,3201},{9,4217},{8,5569},{3,4729},{10,7574},{9,2},{3,1235},{3,4622},{7,5911},{9,2691},{2,5191},{1,1224},{1,6354},{1,9154},{7,526},{8,4102},{6,10},{3,6958},{5,5208},{9,8862},{5,169},{9,950},{3,7009},{2,7013},{7,649},{5,223},{8,3060},{4,4879},{7,9838},{4,5377},{9,2280},{10,5486},{5,1002},{5,6292},{10,7},{7,7628},{4,9727},{3,2118},{10,8780},{5,945},{5,3619},{1,6791},{1,3772},{5,7441},{8,6515},{1,5375},{3,5943},{5,1835},{3,3894},{1,6613},{1,4},{2,7780},{3,5737},{10,8643},{7,5966},{3,2710},{7,7360},{7,1065},{8,6651},{8,2},{2,4944},{1,6636},{2,3706},{7,6540},{8,1755},{9,5367},{6,8979},{8,7643},{8,5623},{9,9769},{2,8321},{3,6719},{4,915},{7,6621},{8,3661},{10,7550},{8,2878},{1,7},{1,3072},{7,6048},{5,4081},{3,1274},{3,7},{9,1972},{7,3},{7,7532},{8,4149},{1,9870},{2,6534},{8,8},{5,647},{10,4},{3,9950},{4,2084},{1,5},{3,3071},{10,8053},{4,7204},{7,7948},{2,5514},{2,5867},{3,9},{8,2171},{4,2959},{5,5616},{1,8503},{9,1520},{3,4044},{1,7059},{9,2093},{1,742},{2,6749},{7,9100},{8,8204},{4,6630},{1,5077},{10,9963},{5,3215},{4,9924},{3,666},{3,6788},{9,8063},{1,8223},{1,9},{8,8771},{2,8475},{3,316},{2,4006},{2,3799},{5,2030},{4,2677},{1,2996},{4,2742},{2,1411},{7,6792},{9,2661},{9,6154},{7,510},{9,428},{4,7767},{5,1531},{9,5679},{7,7},{1,5707},{2,6},{5,1296},{3,7187},{7,5},{10,8491},{3,1418},{2,381},{3,3308},{7,3481},{3,8553},{8,7547},{5,642},{7,8695},{5,6930},{5,3142},{3,4864},{9,6229},{4,2450},{8,72},{10,4743},{9,4618},{8,8130},{3,4487},{3,6767},{1,6946},{2,5994},{1,6055},{7,6987},{10,6080},{5,6139},{5,949},{7,1788},{9,2547},{3,4},{5,4296},{4,5},{4,8416},{3,3614},{7,8685},{9,9765},{9,2288},{2,545},{7,4091},{8,2886},{5,6847},{1,2734},{1,7565},{5,7600},{9,4344},{9,700},{3,3234},{3,5384},{5,7},{5,9916},{8,8411},{1,6813},{4,7},{9,7853},{1,9005},{9,601},{7,873},{7,7476},{1,6417},{7,1498},{1,7305},{3,4004},{7,3491},{9,9631},{1,2607},{3,7133},{5,9010},{1,9379},{5,4822},{10,724},{3,331},{8,3555},{1,3099},{9,9040},{5,2243},{9,10},{2,113},{5,2698},{9,5155},{3,9443},{2,7930},{6,7},{10,9846},{2,8942},{1,6060},{1,9871},{7,7474},{9,1},{3,6743},{4,4979},{7,2015},{3,193},{1,8},{3,3720},{2,9},{7,3404},{1},{2},{3},{4},{5},{6},{7},{8},{9},{10}};
        Map<Integer, Set<Integer>> followers = new HashMap<>();
        Map<Integer, Set<Integer>> tweets = new HashMap<>();

        for (int i = 0; i < action.length; i++) {
            if(action[i].equals("Twitter")) {
//                System.out.println("Twitter twitter = new Twitter();");
            }
            if(action[i].equals("postTweet")) {
//                System.out.println("twitter.postTweet(" + value[i][0] + "," + value[i][1] + ");");

            }
            if(action[i].equals("follow")) {
//                System.out.println("twitter.follow(" + value[i][0] + "," + value[i][1] + ");");
            }
            if(action[i].equals("unfollow")) {
//                System.out.println("twitter.unfollow(" + value[i][0] + "," + value[i][1] + ");");
            }
            if(action[i].equals("getNewsFeed")) {
//                System.out.println("twitter.getNewsFeed(" + value[i][0] + ");");
            }

        }

        Twitter twitter = new Twitter();
        twitter.postTweet(3,9998);
        twitter.unfollow(7,10);
        twitter.postTweet(9,4395);
        twitter.postTweet(1,1201);
        twitter.postTweet(5,1977);
        twitter.postTweet(3,8997);
        twitter.postTweet(9,3526);
        twitter.postTweet(9,5593);
        twitter.postTweet(5,2318);
        twitter.postTweet(1,2961);
        twitter.postTweet(5,4269);
        twitter.postTweet(5,2441);
        twitter.postTweet(2,594);
        twitter.postTweet(1,2717);
        twitter.postTweet(1,6755);
        twitter.postTweet(1,9059);
        twitter.postTweet(7,4017);
        twitter.postTweet(7,645);
        twitter.postTweet(8,9472);
        twitter.postTweet(7,8607);
        twitter.postTweet(5,403);
        twitter.postTweet(4,1789);
        twitter.postTweet(4,2254);
        twitter.postTweet(4,5008);
        twitter.postTweet(8,6724);
        twitter.postTweet(1,6634);
        twitter.postTweet(8,8552);
        twitter.postTweet(9,3813);
        twitter.postTweet(9,1522);
        twitter.postTweet(1,7601);
        twitter.postTweet(1,3368);
        twitter.follow(5,1);
        twitter.postTweet(9,5149);
        twitter.postTweet(4,4368);
        twitter.postTweet(5,9131);
        twitter.postTweet(1,703);
        twitter.postTweet(9,4365);
        twitter.unfollow(2,3);
        twitter.postTweet(5,9729);
        twitter.follow(5,4);
        twitter.postTweet(7,7733);
        twitter.postTweet(8,5686);
        twitter.postTweet(1,2108);
        twitter.postTweet(9,2292);
        twitter.postTweet(1,8801);
        twitter.postTweet(7,7672);
        twitter.postTweet(7,8991);
        twitter.postTweet(9,1684);
        twitter.follow(8,5);
        twitter.postTweet(5,5858);
        twitter.postTweet(5,7989);
        twitter.postTweet(7,1027);
        twitter.postTweet(3,6949);
        twitter.postTweet(3,9501);
        twitter.postTweet(1,9116);
        twitter.unfollow(6,2);
        twitter.postTweet(4,2816);
        twitter.postTweet(7,5132);
        twitter.postTweet(1,6458);
        twitter.postTweet(9,5835);
        twitter.postTweet(7,9409);
        twitter.postTweet(8,5930);
        twitter.postTweet(8,8111);
        twitter.postTweet(4,8602);
        twitter.follow(6,9);
        twitter.postTweet(3,8234);
        twitter.postTweet(5,5627);
        twitter.postTweet(8,22);
        twitter.postTweet(3,3510);
        twitter.postTweet(8,4810);
        twitter.postTweet(3,9742);
        twitter.postTweet(10,4010);
        twitter.postTweet(5,6869);
        twitter.postTweet(3,7768);
        twitter.postTweet(4,6774);
        twitter.postTweet(3,1471);
        twitter.postTweet(7,6123);
        twitter.unfollow(1,5);
        twitter.postTweet(2,6356);
        twitter.postTweet(8,692);
        twitter.postTweet(1,3965);
        twitter.postTweet(1,8290);
        twitter.postTweet(9,3117);
        twitter.postTweet(2,3675);
        twitter.unfollow(4,3);
        twitter.postTweet(4,4033);
        twitter.postTweet(2,2725);
        twitter.postTweet(8,3698);
        twitter.postTweet(9,4326);
        twitter.postTweet(3,5351);
        twitter.postTweet(3,4897);
        twitter.postTweet(5,5549);
        twitter.follow(9,10);
        twitter.postTweet(8,8468);
        twitter.postTweet(5,754);
        twitter.postTweet(3,6988);
        twitter.postTweet(3,4360);
        twitter.postTweet(8,8755);
        twitter.postTweet(7,6670);
        twitter.postTweet(3,8910);
        twitter.follow(7,6);
        twitter.postTweet(7,6760);
        twitter.follow(1,2);
        twitter.postTweet(4,5977);
        twitter.postTweet(9,3087);
        twitter.follow(3,5);
        twitter.postTweet(7,8251);
        twitter.postTweet(9,5892);
        twitter.postTweet(5,3214);
        twitter.postTweet(3,9265);
        twitter.postTweet(7,8750);
        twitter.postTweet(3,3089);
        twitter.postTweet(1,9847);
        twitter.postTweet(8,479);
        twitter.postTweet(3,8519);
        twitter.postTweet(3,8960);
        twitter.unfollow(8,5);
        twitter.postTweet(2,7937);
        twitter.follow(1,3);
        twitter.postTweet(7,3833);
        twitter.follow(7,6);
        twitter.postTweet(3,4340);
        twitter.postTweet(7,3969);
        twitter.unfollow(1,7);
        twitter.postTweet(5,7559);
        twitter.postTweet(9,2369);
        twitter.postTweet(3,8007);
        twitter.postTweet(9,2221);
        twitter.postTweet(5,781);
        twitter.postTweet(4,3659);
        twitter.postTweet(2,3097);
        twitter.postTweet(8,539);
        twitter.postTweet(7,7639);
        twitter.postTweet(9,2928);
        twitter.postTweet(1,4187);
        twitter.unfollow(1,6);
        twitter.postTweet(10,7403);
        twitter.postTweet(7,3851);
        twitter.postTweet(7,8496);
        twitter.postTweet(3,1926);
        twitter.postTweet(1,6203);
        twitter.postTweet(1,4858);
        twitter.postTweet(1,1851);
        twitter.postTweet(5,286);
        twitter.postTweet(8,7446);
        twitter.postTweet(9,462);
        twitter.follow(9,5);
        twitter.postTweet(9,4659);
        twitter.postTweet(7,7716);
        twitter.unfollow(3,8);
        twitter.postTweet(4,7450);
        twitter.postTweet(5,2446);
        twitter.postTweet(9,9220);
        twitter.postTweet(10,2597);
        twitter.postTweet(3,1904);
        twitter.postTweet(9,509);
        twitter.postTweet(3,3210);
        twitter.postTweet(3,1737);
        twitter.postTweet(5,7753);
        twitter.postTweet(5,4703);
        twitter.postTweet(1,3865);
        twitter.postTweet(4,3665);
        twitter.postTweet(9,5105);
        twitter.postTweet(9,9955);
        twitter.postTweet(8,1957);
        twitter.postTweet(1,3412);
        twitter.postTweet(7,9823);
        twitter.postTweet(3,1916);
        twitter.postTweet(8,6610);
        twitter.postTweet(4,7397);
        twitter.postTweet(1,3814);
        twitter.postTweet(8,4513);
        twitter.postTweet(5,3236);
        twitter.postTweet(3,4661);
        twitter.postTweet(4,6978);
        twitter.postTweet(5,5320);
        twitter.postTweet(7,9799);
        twitter.postTweet(4,8326);
        twitter.follow(7,10);
        twitter.postTweet(8,9786);
        twitter.postTweet(3,2619);
        twitter.postTweet(5,9925);
        twitter.postTweet(9,6691);
        twitter.postTweet(4,1129);
        twitter.postTweet(7,3158);
        twitter.postTweet(1,9812);
        twitter.postTweet(3,7586);
        twitter.postTweet(3,4451);
        twitter.postTweet(1,3286);
        twitter.postTweet(9,6386);
        twitter.postTweet(7,2332);
        twitter.postTweet(5,7724);
        twitter.postTweet(3,2655);
        twitter.postTweet(5,7932);
        twitter.postTweet(7,4627);
        twitter.postTweet(2,4690);
        twitter.postTweet(5,1571);
        twitter.postTweet(1,4547);
        twitter.postTweet(7,1355);
        twitter.postTweet(5,5579);
        twitter.postTweet(9,2650);
        twitter.postTweet(4,2992);
        twitter.postTweet(2,6103);
        twitter.postTweet(8,4980);
        twitter.postTweet(4,6797);
        twitter.postTweet(4,4214);
        twitter.follow(9,1);
        twitter.postTweet(4,7496);
        twitter.postTweet(9,369);
        twitter.postTweet(9,772);
        twitter.postTweet(2,3610);
        twitter.postTweet(8,6339);
        twitter.postTweet(1,5107);
        twitter.follow(3,1);
        twitter.postTweet(5,7253);
        twitter.postTweet(3,3425);
        twitter.postTweet(7,8312);
        twitter.postTweet(1,9883);
        twitter.postTweet(2,548);
        twitter.postTweet(8,8550);
        twitter.postTweet(4,7139);
        twitter.postTweet(4,5222);
        twitter.follow(4,3);
        twitter.postTweet(3,2059);
        twitter.postTweet(9,6747);
        twitter.postTweet(7,9804);
        twitter.postTweet(7,450);
        twitter.postTweet(5,2338);
        twitter.postTweet(5,688);
        twitter.postTweet(8,3953);
        twitter.postTweet(10,8880);
        twitter.postTweet(3,9453);
        twitter.postTweet(8,9530);
        twitter.postTweet(5,2179);
        twitter.postTweet(5,3901);
        twitter.postTweet(5,9643);
        twitter.postTweet(1,864);
        twitter.postTweet(7,4736);
        twitter.postTweet(9,4670);
        twitter.follow(1,2);
        twitter.postTweet(5,6004);
        twitter.postTweet(2,7799);
        twitter.postTweet(1,7491);
        twitter.postTweet(9,1496);
        twitter.postTweet(9,3299);
        twitter.postTweet(7,9332);
        twitter.postTweet(5,7659);
        twitter.postTweet(3,2470);
        twitter.postTweet(9,2511);
        twitter.follow(4,2);
        twitter.postTweet(7,2666);
        twitter.postTweet(4,6620);
        twitter.postTweet(7,6239);
        twitter.postTweet(9,5271);
        twitter.postTweet(2,4345);
        twitter.unfollow(2,6);
        twitter.postTweet(1,7117);
        twitter.postTweet(3,2624);
        twitter.postTweet(4,1114);
        twitter.postTweet(7,4836);
        twitter.postTweet(2,1998);
        twitter.postTweet(3,9839);
        twitter.postTweet(5,792);
        twitter.postTweet(4,1668);
        twitter.postTweet(7,9455);
        twitter.postTweet(10,7654);
        twitter.unfollow(4,10);
        twitter.postTweet(7,266);
        twitter.postTweet(7,2708);
        twitter.follow(7,8);
        twitter.postTweet(2,4246);
        twitter.unfollow(5,1);
        twitter.postTweet(9,6449);
        twitter.postTweet(9,6377);
        twitter.postTweet(5,4909);
        twitter.follow(6,1);
        twitter.postTweet(1,4946);
        twitter.postTweet(4,8542);
        twitter.postTweet(3,3680);
        twitter.postTweet(9,3340);
        twitter.postTweet(4,2682);
        twitter.postTweet(7,9802);
        twitter.postTweet(3,306);
        twitter.postTweet(5,3348);
        twitter.postTweet(8,3537);
        twitter.follow(9,8);
        twitter.postTweet(8,6272);
        twitter.postTweet(4,1976);
        twitter.postTweet(1,7928);
        twitter.postTweet(5,4827);
        twitter.postTweet(1,4510);
        twitter.postTweet(2,6226);
        twitter.postTweet(4,9659);
        twitter.postTweet(9,4905);
        twitter.follow(5,8);
        twitter.postTweet(2,7113);
        twitter.postTweet(3,6523);
        twitter.postTweet(9,701);
        twitter.postTweet(4,823);
        twitter.postTweet(9,3349);
        twitter.postTweet(7,7539);
        twitter.follow(3,2);
        twitter.postTweet(8,5387);
        twitter.postTweet(4,8268);
        twitter.postTweet(5,2192);
        twitter.postTweet(5,2488);
        twitter.postTweet(5,5294);
        twitter.postTweet(9,3496);
        twitter.postTweet(7,2799);
        twitter.postTweet(1,868);
        twitter.postTweet(5,1761);
        twitter.follow(4,5);
        twitter.postTweet(2,5706);
        twitter.postTweet(1,1642);
        twitter.postTweet(1,1579);
        twitter.postTweet(3,2397);
        twitter.postTweet(5,5725);
        twitter.postTweet(4,4711);
        twitter.postTweet(5,2837);
        twitter.postTweet(10,3975);
        twitter.postTweet(9,5979);
        twitter.postTweet(5,9413);
        twitter.postTweet(9,8252);
        twitter.postTweet(7,3314);
        twitter.postTweet(7,8300);
        twitter.postTweet(3,8932);
        twitter.postTweet(1,8032);
        twitter.postTweet(9,6821);
        twitter.postTweet(9,6643);
        twitter.postTweet(7,928);
        twitter.postTweet(2,5044);
        twitter.postTweet(3,1046);
        twitter.postTweet(8,2058);
        twitter.follow(2,8);
        twitter.postTweet(4,1051);
        twitter.postTweet(8,4492);
        twitter.postTweet(8,9326);
        twitter.postTweet(8,3022);
        twitter.follow(8,2);
        twitter.postTweet(5,7320);
        twitter.postTweet(1,6837);
        twitter.postTweet(5,7636);
        twitter.postTweet(1,2085);
        twitter.follow(9,7);
        twitter.postTweet(3,8184);
        twitter.postTweet(4,1719);
        twitter.postTweet(1,6365);
        twitter.postTweet(9,6834);
        twitter.unfollow(4,4);
        twitter.postTweet(1,3240);
        twitter.postTweet(3,4966);
        twitter.postTweet(3,56);
        twitter.unfollow(1,6);
        twitter.postTweet(3,77);
        twitter.postTweet(3,5898);
        twitter.postTweet(5,1495);
        twitter.postTweet(9,8368);
        twitter.postTweet(9,7650);
        twitter.postTweet(7,6256);
        twitter.postTweet(1,9721);
        twitter.postTweet(1,4537);
        twitter.postTweet(2,7957);
        twitter.postTweet(7,3970);
        twitter.postTweet(1,964);
        twitter.postTweet(5,4473);
        twitter.postTweet(7,5953);
        twitter.postTweet(1,164);
        twitter.follow(5,2);
        twitter.postTweet(5,3940);
        twitter.postTweet(1,2010);
        twitter.postTweet(5,5635);
        twitter.postTweet(9,7708);
        twitter.postTweet(1,1801);
        twitter.postTweet(3,4361);
        twitter.postTweet(3,5708);
        twitter.postTweet(4,4099);
        twitter.follow(8,1);
        twitter.postTweet(3,6311);
        twitter.follow(9,7);
        twitter.postTweet(9,4636);
        twitter.postTweet(1,3116);
        twitter.postTweet(5,5113);
        twitter.postTweet(4,9348);
        twitter.postTweet(3,9164);
        twitter.postTweet(8,4484);
        twitter.postTweet(5,3956);
        twitter.postTweet(10,5243);
        twitter.postTweet(7,4316);
        twitter.postTweet(1,7889);
        twitter.postTweet(10,7817);
        twitter.postTweet(9,5546);
        twitter.postTweet(5,7987);
        twitter.postTweet(2,9738);
        twitter.postTweet(4,4588);
        twitter.postTweet(3,2406);
        twitter.postTweet(2,1321);
        twitter.postTweet(5,4883);
        twitter.postTweet(5,5342);
        twitter.postTweet(8,499);
        twitter.postTweet(3,8039);
        twitter.postTweet(2,8141);
        twitter.postTweet(7,3069);
        twitter.postTweet(7,2887);
        twitter.postTweet(8,5811);
        twitter.postTweet(5,1340);
        twitter.postTweet(3,2023);
        twitter.postTweet(1,5495);
        twitter.postTweet(9,6885);
        twitter.postTweet(8,3730);
        twitter.postTweet(9,2817);
        twitter.postTweet(10,8427);
        twitter.follow(5,2);
        twitter.postTweet(4,577);
        twitter.postTweet(9,7587);
        twitter.postTweet(6,8736);
        twitter.postTweet(1,6878);
        twitter.follow(10,5);
        twitter.postTweet(8,6887);
        twitter.postTweet(7,910);
        twitter.postTweet(5,7207);
        twitter.postTweet(1,8);
        twitter.postTweet(3,9138);
        twitter.follow(5,7);
        twitter.postTweet(8,9886);
        twitter.postTweet(8,8975);
        twitter.postTweet(9,8812);
        twitter.postTweet(4,886);
        twitter.postTweet(8,6504);
        twitter.follow(10,4);
        twitter.postTweet(1,8205);
        twitter.postTweet(9,3697);
        twitter.postTweet(7,6371);
        twitter.postTweet(5,8010);
        twitter.postTweet(4,5810);
        twitter.postTweet(7,7362);
        twitter.postTweet(2,5949);
        twitter.postTweet(4,8819);
        twitter.unfollow(4,6);
        twitter.postTweet(4,2841);
        twitter.postTweet(8,3708);
        twitter.follow(1,6);
        twitter.postTweet(3,8713);
        twitter.postTweet(9,5449);
        twitter.postTweet(9,9517);
        twitter.postTweet(3,9191);
        twitter.postTweet(5,9619);
        twitter.postTweet(7,5073);
        twitter.postTweet(1,2290);
        twitter.postTweet(2,8482);
        twitter.unfollow(6,9);
        twitter.postTweet(5,6432);
        twitter.postTweet(9,736);
        twitter.postTweet(2,6566);
        twitter.postTweet(4,4658);
        twitter.postTweet(8,420);
        twitter.postTweet(3,9037);
        twitter.postTweet(5,9728);
        twitter.postTweet(5,8661);
        twitter.follow(3,9);
        twitter.postTweet(5,9935);
        twitter.postTweet(8,4240);
        twitter.postTweet(2,1965);
        twitter.postTweet(1,4655);
        twitter.postTweet(8,6251);
        twitter.postTweet(9,5927);
        twitter.postTweet(8,9853);
        twitter.follow(9,5);
        twitter.postTweet(9,6927);
        twitter.postTweet(1,4577);
        twitter.postTweet(10,639);
        twitter.postTweet(5,817);
        twitter.postTweet(7,7913);
        twitter.follow(7,4);
        twitter.postTweet(5,9227);
        twitter.postTweet(8,3201);
        twitter.postTweet(9,4217);
        twitter.postTweet(8,5569);
        twitter.postTweet(3,4729);
        twitter.postTweet(10,7574);
        twitter.unfollow(9,2);
        twitter.postTweet(3,1235);
        twitter.postTweet(3,4622);
        twitter.postTweet(7,5911);
        twitter.postTweet(9,2691);
        twitter.postTweet(2,5191);
        twitter.postTweet(1,1224);
        twitter.postTweet(1,6354);
        twitter.postTweet(1,9154);
        twitter.postTweet(7,526);
        twitter.postTweet(8,4102);
        twitter.follow(6,10);
        twitter.postTweet(3,6958);
        twitter.postTweet(5,5208);
        twitter.postTweet(9,8862);
        twitter.postTweet(5,169);
        twitter.postTweet(9,950);
        twitter.postTweet(3,7009);
        twitter.postTweet(2,7013);
        twitter.postTweet(7,649);
        twitter.postTweet(5,223);
        twitter.postTweet(8,3060);
        twitter.postTweet(4,4879);
        twitter.postTweet(7,9838);
        twitter.postTweet(4,5377);
        twitter.postTweet(9,2280);
        twitter.postTweet(10,5486);
        twitter.postTweet(5,1002);
        twitter.postTweet(5,6292);
        twitter.follow(10,7);
        twitter.postTweet(7,7628);
        twitter.postTweet(4,9727);
        twitter.postTweet(3,2118);
        twitter.postTweet(10,8780);
        twitter.postTweet(5,945);
        twitter.postTweet(5,3619);
        twitter.postTweet(1,6791);
        twitter.postTweet(1,3772);
        twitter.postTweet(5,7441);
        twitter.postTweet(8,6515);
        twitter.postTweet(1,5375);
        twitter.postTweet(3,5943);
        twitter.postTweet(5,1835);
        twitter.postTweet(3,3894);
        twitter.postTweet(1,6613);
        twitter.unfollow(1,4);
        twitter.postTweet(2,7780);
        twitter.postTweet(3,5737);
        twitter.postTweet(10,8643);
        twitter.postTweet(7,5966);
        twitter.postTweet(3,2710);
        twitter.postTweet(7,7360);
        twitter.postTweet(7,1065);
        twitter.postTweet(8,6651);
        twitter.follow(8,2);
        twitter.postTweet(2,4944);
        twitter.postTweet(1,6636);
        twitter.postTweet(2,3706);
        twitter.postTweet(7,6540);
        twitter.postTweet(8,1755);
        twitter.postTweet(9,5367);
        twitter.postTweet(6,8979);
        twitter.postTweet(8,7643);
        twitter.postTweet(8,5623);
        twitter.postTweet(9,9769);
        twitter.postTweet(2,8321);
        twitter.postTweet(3,6719);
        twitter.postTweet(4,915);
        twitter.postTweet(7,6621);
        twitter.postTweet(8,3661);
        twitter.postTweet(10,7550);
        twitter.postTweet(8,2878);
        twitter.unfollow(1,7);
        twitter.postTweet(1,3072);
        twitter.postTweet(7,6048);
        twitter.postTweet(5,4081);
        twitter.postTweet(3,1274);
        twitter.follow(3,7);
        twitter.postTweet(9,1972);
        twitter.follow(7,3);
        twitter.postTweet(7,7532);
        twitter.postTweet(8,4149);
        twitter.postTweet(1,9870);
        twitter.postTweet(2,6534);
        twitter.unfollow(8,8);
        twitter.postTweet(5,647);
        twitter.follow(10,4);
        twitter.postTweet(3,9950);
        twitter.postTweet(4,2084);
        twitter.follow(1,5);
        twitter.postTweet(3,3071);
        twitter.postTweet(10,8053);
        twitter.postTweet(4,7204);
        twitter.postTweet(7,7948);
        twitter.postTweet(2,5514);
        twitter.postTweet(2,5867);
        twitter.follow(3,9);
        twitter.postTweet(8,2171);
        twitter.postTweet(4,2959);
        twitter.postTweet(5,5616);
        twitter.postTweet(1,8503);
        twitter.postTweet(9,1520);
        twitter.postTweet(3,4044);
        twitter.postTweet(1,7059);
        twitter.postTweet(9,2093);
        twitter.postTweet(1,742);
        twitter.postTweet(2,6749);
        twitter.postTweet(7,9100);
        twitter.postTweet(8,8204);
        twitter.postTweet(4,6630);
        twitter.postTweet(1,5077);
        twitter.postTweet(10,9963);
        twitter.postTweet(5,3215);
        twitter.postTweet(4,9924);
        twitter.postTweet(3,666);
        twitter.postTweet(3,6788);
        twitter.postTweet(9,8063);
        twitter.postTweet(1,8223);
        twitter.follow(1,9);
        twitter.postTweet(8,8771);
        twitter.postTweet(2,8475);
        twitter.postTweet(3,316);
        twitter.postTweet(2,4006);
        twitter.postTweet(2,3799);
        twitter.postTweet(5,2030);
        twitter.postTweet(4,2677);
        twitter.postTweet(1,2996);
        twitter.postTweet(4,2742);
        twitter.postTweet(2,1411);
        twitter.postTweet(7,6792);
        twitter.postTweet(9,2661);
        twitter.postTweet(9,6154);
        twitter.postTweet(7,510);
        twitter.postTweet(9,428);
        twitter.postTweet(4,7767);
        twitter.postTweet(5,1531);
        twitter.postTweet(9,5679);
        twitter.follow(7,7);
        twitter.postTweet(1,5707);
        twitter.follow(2,6);
        twitter.postTweet(5,1296);
        twitter.postTweet(3,7187);
        twitter.follow(7,5);
        twitter.postTweet(10,8491);
        twitter.postTweet(3,1418);
        twitter.postTweet(2,381);
        twitter.postTweet(3,3308);
        twitter.postTweet(7,3481);
        twitter.postTweet(3,8553);
        twitter.postTweet(8,7547);
        twitter.postTweet(5,642);
        twitter.postTweet(7,8695);
        twitter.postTweet(5,6930);
        twitter.postTweet(5,3142);
        twitter.postTweet(3,4864);
        twitter.postTweet(9,6229);
        twitter.postTweet(4,2450);
        twitter.postTweet(8,72);
        twitter.postTweet(10,4743);
        twitter.postTweet(9,4618);
        twitter.postTweet(8,8130);
        twitter.postTweet(3,4487);
        twitter.postTweet(3,6767);
        twitter.postTweet(1,6946);
        twitter.postTweet(2,5994);
        twitter.postTweet(1,6055);
        twitter.postTweet(7,6987);
        twitter.postTweet(10,6080);
        twitter.postTweet(5,6139);
        twitter.postTweet(5,949);
        twitter.postTweet(7,1788);
        twitter.postTweet(9,2547);
        twitter.unfollow(3,4);
        twitter.postTweet(5,4296);
        twitter.follow(4,5);
        twitter.postTweet(4,8416);
        twitter.postTweet(3,3614);
        twitter.postTweet(7,8685);
        twitter.postTweet(9,9765);
        twitter.postTweet(9,2288);
        twitter.postTweet(2,545);
        twitter.postTweet(7,4091);
        twitter.postTweet(8,2886);
        twitter.postTweet(5,6847);
        twitter.postTweet(1,2734);
        twitter.postTweet(1,7565);
        twitter.postTweet(5,7600);
        twitter.postTweet(9,4344);
        twitter.postTweet(9,700);
        twitter.postTweet(3,3234);
        twitter.postTweet(3,5384);
        twitter.follow(5,7);
        twitter.postTweet(5,9916);
        twitter.postTweet(8,8411);
        twitter.postTweet(1,6813);
        twitter.follow(4,7);
        twitter.postTweet(9,7853);
        twitter.postTweet(1,9005);
        twitter.postTweet(9,601);
        twitter.postTweet(7,873);
        twitter.postTweet(7,7476);
        twitter.postTweet(1,6417);
        twitter.postTweet(7,1498);
        twitter.postTweet(1,7305);
        twitter.postTweet(3,4004);
        twitter.postTweet(7,3491);
        twitter.postTweet(9,9631);
        twitter.postTweet(1,2607);
        twitter.postTweet(3,7133);
        twitter.postTweet(5,9010);
        twitter.postTweet(1,9379);
        twitter.postTweet(5,4822);
        twitter.postTweet(10,724);
        twitter.postTweet(3,331);
        twitter.postTweet(8,3555);
        twitter.postTweet(1,3099);
        twitter.postTweet(9,9040);
        twitter.postTweet(5,2243);
        twitter.follow(9,10);
        twitter.postTweet(2,113);
        twitter.postTweet(5,2698);
        twitter.postTweet(9,5155);
        twitter.postTweet(3,9443);
        twitter.postTweet(2,7930);
        twitter.unfollow(6,7);
        twitter.postTweet(10,9846);
        twitter.postTweet(2,8942);
        twitter.postTweet(1,6060);
        twitter.postTweet(1,9871);
        twitter.postTweet(7,7474);
        twitter.follow(9,1);
        twitter.postTweet(3,6743);
        twitter.postTweet(4,4979);
        twitter.postTweet(7,2015);
        twitter.postTweet(3,193);
        twitter.follow(1,8);
        twitter.postTweet(3,3720);
        twitter.unfollow(2,9);
        twitter.postTweet(7,3404);
        twitter.getNewsFeed(1);
        twitter.getNewsFeed(2);
        twitter.getNewsFeed(3);
        twitter.getNewsFeed(4);
        twitter.getNewsFeed(5);
        twitter.getNewsFeed(6);
        twitter.getNewsFeed(7);
        twitter.getNewsFeed(8);
        twitter.getNewsFeed(9);
        twitter.getNewsFeed(10);
//        Graph g = twitter.graph;
//        Map<Integer, Set<Integer>> followers = g.followers;
    }




}
