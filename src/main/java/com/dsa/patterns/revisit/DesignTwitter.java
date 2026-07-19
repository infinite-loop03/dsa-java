package com.dsa.patterns.revisit;

import java.util.*;

public class DesignTwitter {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(2, 1);
        System.out.println(twitter.getNewsFeed(2));
        twitter.unfollow(2, 1);
        System.out.println(twitter.getNewsFeed(2));
    }

    static class Twitter {

        int timestamp;
        Map<Integer, List<int[]>> userToTweets = new HashMap<>();
        Map<Integer, Set<Integer>> userToFollowers = new HashMap<>();

        void postTweet(int userId, int tweetId) {
            userToTweets.computeIfAbsent(userId, id -> new ArrayList<>()).add(new int[]{timestamp, tweetId});
            timestamp++;
        }

        List<Integer> getNewsFeed(int userId) {
            Set<Integer> followees = userToFollowers.getOrDefault(userId, new HashSet<>());
            followees.add(userId);
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);

            followees.forEach(user -> userToTweets.getOrDefault(user, List.of()).forEach(priorityQueue::offer));

            List<Integer> userFeed = new ArrayList<>();
            while (!priorityQueue.isEmpty() && userFeed.size() < 10) {
                userFeed.add(priorityQueue.poll()[1]);
            }
            return userFeed;
        }

        void follow(int followerId, int followeeId) {
            userToFollowers.computeIfAbsent(followerId, id -> new HashSet<>()).add(followeeId);
        }

        void unfollow(int followerId, int followeeId) {
            userToFollowers.computeIfPresent(followerId, (k, v) -> {
                v.remove(followeeId);
                return v.isEmpty() ? null : v;
            });
        }
    }
}
