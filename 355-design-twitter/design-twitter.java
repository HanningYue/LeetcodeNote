class Twitter {
    class User {
        int userId;
        Set<Integer> followList;
        public User(int userId) {
            this.userId = userId;
            followList = new HashSet<>();
        }
    }
    class Tweet {
        int tweetId;
        int userId;
        public Tweet(int tweetId, int userId) {
            this.tweetId = tweetId;
            this.userId = userId;
        }
    }

    List<Tweet> allTweet;
    Map<Integer, User> userMap;
    public Twitter() {
        userMap = new HashMap<>();
        allTweet = new ArrayList<>();
    }
    private User getUser(int userId) {
        userMap.putIfAbsent(userId, new User(userId));
        return userMap.get(userId);
    }
    public void postTweet(int userId, int tweetId) {
        User user = getUser(userId);
        allTweet.add(new Tweet(tweetId, userId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        User user = userMap.get(userId);

        List<Integer> last10 = new ArrayList<>();
        int i = allTweet.size() - 1;
        while (last10.size() < 10 && i >= 0) {
            int posterId = allTweet.get(i).userId;
            if (posterId == userId || user.followList.contains(posterId)) {
                last10.add(allTweet.get(i).tweetId);
            }
            i--;
        }
        return last10;
    }
    
    public void follow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        User followee = getUser(followeeId);

        follower.followList.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        User followee = getUser(followeeId);

        if (follower.followList.contains(followeeId)) {
            follower.followList.remove(followeeId);
        }
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