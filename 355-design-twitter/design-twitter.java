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
    Map<Integer, User> userMap;
    public Twitter() {
        userMap = new HashMap<>();
        allTweet = new ArrayList<>();
    }

    public User getUser(int userId) {
        userMap.putIfAbsent(userId, new User(userId));
        return userMap.get(userId);
    }

    public void postTweet(int userId, int tweetId) {
        User user = getUser(userId);
        allTweet.add(new Tweet(userId, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        User user = getUser(userId);

        List<Integer> pastTen = new ArrayList<>();
        int i = allTweet.size() - 1;
        while (i >= 0 && pastTen.size() < 10) {
            int posterId = allTweet.get(i).userId;
            if (posterId == userId || user.followList.contains(posterId)) {
                pastTen.add(allTweet.get(i).tweetId);
            }
            i--;
        }
        return pastTen;
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