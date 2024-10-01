class Tweet {
    int tweetId;
    int userId;
    public Tweet(int tweetId, int userId) {
        this.tweetId = tweetId;
        this.userId = userId;
    }
}
class User {
    int userId;
    Set<Integer> followerList;
    Set<Integer> followingList;
    public User(int userId) {
        followingList = new HashSet<>();
        followerList = new HashSet<>();
        this.userId = userId;
    }
}
class Twitter {
    List<Tweet> tweetList;
    Map<Integer, User> map;
    public Twitter() {
        map = new HashMap<>();
        tweetList = new ArrayList<>();
    }

    private User createUser(int userId) {
        if (map.containsKey(userId)) {
            return map.get(userId);
        }
        User user = new User(userId);
        map.put(userId, user);
        return user;
    }
    
    public void postTweet(int userId, int tweetId) {
        User user = createUser(userId);
        Tweet tweet = new Tweet(tweetId, userId);
        tweetList.add(tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        User user = createUser(userId);
        List<Integer> lastTen = new ArrayList<>();

        int index = tweetList.size() - 1;
        while (index >= 0 && lastTen.size() < 10) {
            Tweet mostRecentTweet = tweetList.get(index);
            int tweetId = mostRecentTweet.tweetId;
            int tweetUserId = mostRecentTweet.userId;
            
            if (user.followingList.contains(tweetUserId) || user.userId == tweetUserId) {
                lastTen.add(tweetId);
            }
            index--;
        }

        return lastTen;
    }
    
    public void follow(int followerId, int followeeId) {
        User follower = createUser(followerId);
        User followee = createUser(followeeId);

        follower.followingList.add(followeeId);
        followee.followerList.add(followerId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        User follower = createUser(followerId);
        User followee = createUser(followeeId);

        follower.followingList.remove(followeeId);
        followee.followerList.remove(followerId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */