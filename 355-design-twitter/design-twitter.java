class User {
    int userId;
    Set<Integer> followList;
    public User(int userId) {
        followList = new HashSet<>();
        this.userId = userId;
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
class Twitter {
    Map<Integer, User> map;
    List<Tweet> allTweet;
    public Twitter() {
        map = new HashMap<>();
        allTweet = new ArrayList<>();
    }
    
    public User createUser(int userId) {
        map.putIfAbsent(userId, new User(userId));
        return map.get(userId);
    }

    public void postTweet(int userId, int tweetId) {
        allTweet.add(new Tweet(tweetId, userId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        User user = createUser(userId);
        List<Integer> pastTen = new ArrayList<>();
        
        int i = allTweet.size() - 1;
        while (i >= 0 && pastTen.size() < 10) {
            Tweet lastTweet = allTweet.get(i);
            int posterId = lastTweet.userId;
            int tweetId = lastTweet.tweetId;
            if (posterId == userId || user.followList.contains(posterId)) {
                pastTen.add(tweetId);
            }
            i--;
        }
        return pastTen;
    }
    
    public void follow(int followerId, int followeeId) {
        User follower = createUser(followerId);
        follower.followList.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        User follower = createUser(followerId);
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