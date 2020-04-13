package April.problem_0355_DesignTwitter;

/*
 * 355. 设计推特
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，
 * 能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 *   1. postTweet(userId, tweetId): 创建一条新的推文
 *   2. getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 *   3. follow(followerId, followeeId): 关注一个用户
 *   4. unfollow(followerId, followeeId): 取消关注一个用户
 *
 * 示例:
 * Twitter twitter = new Twitter();
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 */

import java.util.*;

public class Twitter {
    // 全局使用的时间戳字段
    private static int TIMESTAMP = 0;
    // 存储用户 id 与推文列表的对应关系
    private Map<Integer, Tweet> twitter;

    // 存储用户 id 与他关注的用户列表的对应关系
    private Map<Integer, Set<Integer>> following;
    // 合并 k 组推文使用的数据结构
    private PriorityQueue<Tweet> maxHeap;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        following = new HashMap<>();
        twitter = new HashMap<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2.timestamp - o1.timestamp);
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        TIMESTAMP++;
        Tweet newTweet = new Tweet(tweetId, TIMESTAMP);
        if (twitter.containsKey(userId)) {
            newTweet.next = twitter.get(userId);
        }
        twitter.put(userId, newTweet);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself.
     * Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        // 清空之前的结果
        maxHeap.clear();
        if (twitter.containsKey(userId)) {
            maxHeap.offer(twitter.get(userId));
        }
        Set<Integer> set = following.get(userId);
        if (set != null) {
            for (Integer followee : set) {
                Tweet tweet = twitter.get(followee);
                if (tweet != null) {
                    maxHeap.offer(tweet);
                }
            }
        }
        ArrayList<Integer> tweetList = new ArrayList<>(10);
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            Tweet tweet = maxHeap.poll();
            tweetList.add(tweet.id);
            if (tweet.next != null) {
                maxHeap.offer(tweet.next);
            }
            count++;
        }
        return tweetList;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (following.containsKey(followerId)) {
            following.get(followerId).add(followeeId);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            following.put(followerId, set);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        Set<Integer> set = following.get(followerId);
        if (set != null) {
            set.remove(followeeId);
        }
    }

    /**
     * 推文类，是一个单链表
     */
    private class Tweet {
        // 推文 id
        private int id;
        // 发推文的时间戳
        private int timestamp;
        private Tweet next;

        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }
}
