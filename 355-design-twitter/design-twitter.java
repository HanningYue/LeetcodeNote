/**
OOD的设计去解决问题, global variable -> tweetList and userHashMap
1. Create Addtional Class Tweet and User
2. Tweet class contains userId and tweetId
3. User class contains userId and a Set<Integer> follows that manages follower and followee
4. For each function, we need to check whether the user itself or follower/followee is created?
5. getNewsFeed
    We want the last 10 posts, so check TweetList, if the poster are user itself or people user follows, add
    Tweet class has tweetId, and 'i' is equals to tweetList.size() - 1, we need to use tweetList.get(i) equals each tweet
*/
class Twitter {
    class User {
        int userId;
        Set<Integer> follows;
        public User(int userId) {
            this.userId = userId;
            follows = new HashSet<>();
        }
    }
    class Tweet {
        int tweetId;
        int userId;
        public Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }

    List<Tweet> tweetList;
    Map<Integer, User> map;
    public Twitter() {
        tweetList = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!map.containsKey(userId)) {
            map.put(userId, new User(userId));
        }
        tweetList.add(new Tweet(userId, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> last10 = new ArrayList<>();
        if (!map.containsKey(userId)) {
            map.put(userId, new User(userId));
        }

        int i = tweetList.size() - 1;
        while (last10.size() < 10 && i >= 0) {
            if (tweetList.get(i).userId == userId 
                    || map.get(userId).follows.contains(tweetList.get(i).userId)) 
            {
                last10.add(tweetList.get(i).tweetId);
            }
            i--;
        }
        return last10;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)) {
            map.put(followerId, new User(followerId));
        }
        if (!map.containsKey(followeeId)) {
            map.put(followeeId, new User(followeeId));
        }
        User user = map.get(followerId);
        user.follows.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)) {
            map.put(followerId, new User(followerId));
        }
        if (!map.containsKey(followeeId)) {
            map.put(followeeId, new User(followeeId));
        }
        User user = map.get(followerId);
        user.follows.remove(followeeId);   
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