class Twitter {
    class User {
        Set<Integer> followList;
        int userId;
        public User(int userId) {
            followList = new HashSet<>();
            this.userId = userId;
        }
    }
    class Tweet {
        int tweetId, userId;
        public Tweet(int tweetId, int userId) {
            this.tweetId = tweetId;
            this.userId = userId;
        }
    }

    List<Tweet> tweetList;
    Map<Integer, User> userMap;
    public Twitter() {
        userMap = new HashMap<>();
        tweetList = new ArrayList<>();
    }
    
    private User getUser(int userId) {
        userMap.putIfAbsent(userId, new User(userId));
        return userMap.get(userId);
    }

    public void postTweet(int userId, int tweetId) {
        User user = getUser(userId);
        tweetList.add(new Tweet(tweetId, userId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        User user = getUser(userId);
        List<Integer> last10Tweet = new ArrayList<>();
        int i = tweetList.size() - 1;
        while (last10Tweet.size() < 10 && i >= 0) {
            int posterId = tweetList.get(i).userId;
            if (posterId == userId || userMap.get(userId).followList.contains(posterId)) {
                last10Tweet.add(tweetList.get(i).tweetId);
            }
            i--;
        }
        return last10Tweet;
    }
    
    public void follow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        User followee = getUser(followeeId);
        follower.followList.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        User followee = getUser(followeeId);
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