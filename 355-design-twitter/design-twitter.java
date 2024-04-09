class User {
    int userId;
    Set<Integer> followList;
    public User(int userId) {
        this.userId = userId;
        followList = new HashSet<>();
    }
}
class Tweet {
    int userId;
    int tweetId;
    public Tweet(int userId, int tweetId) {
        this.userId = userId;
        this.tweetId = tweetId;
    }
}
class Twitter {
    List<Tweet> allTweet;
    Map<Integer, User> map;
    public Twitter() {
        map = new HashMap<>();
        allTweet = new ArrayList<>();
    }
    
    public User getUser(int userId) {
        map.putIfAbsent(userId, new User(userId));
        return map.get(userId);
    }

    public void postTweet(int userId, int tweetId) {
        allTweet.add(new Tweet(userId, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        User user = getUser(userId);
        List<Integer> lastTen = new ArrayList<>();
        int i = allTweet.size() - 1;
        while (i >= 0 && lastTen.size() < 10) {
            Tweet tweet = allTweet.get(i);
            if (tweet.userId == userId || user.followList.contains(tweet.userId)) {
                lastTen.add(tweet.tweetId);
            }
            i--;
        }
        return lastTen;
    }
    
    public void follow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        follower.followList.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        follower.followList.remove(followeeId);
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