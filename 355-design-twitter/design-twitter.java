class Tweet {
    int userId, tweetId;
    public Tweet(int userId, int tweetId) {
        this.userId = userId;
        this.tweetId = tweetId;
    }
}
class User {
    int userId;
    Set<Integer> followList;
    public User(int userId) {
        this.userId = userId;
        followList = new HashSet<>();
    }
}
class Twitter {
    Map<Integer, User> map;
    List<Tweet> allTweet;
    public Twitter() {
        allTweet = new ArrayList<>();
        map = new HashMap<>();
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
        List<Integer> pastTen = new ArrayList<>();
        int index = allTweet.size() - 1;

        while (index >= 0 && pastTen.size() < 10) {
            Tweet currentTweet = allTweet.get(index);
            if (currentTweet.userId == userId
            ||  user.followList.contains(currentTweet.userId)) {
                pastTen.add(currentTweet.tweetId);
            }
            index--;
        }
        return pastTen;
    }
    
    public void follow(int followerId, int followeeId) {
        User user = getUser(followerId);
        user.followList.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        User user = getUser(followerId);
        user.followList.remove(followeeId);
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