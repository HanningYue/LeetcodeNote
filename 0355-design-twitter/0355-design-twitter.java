/**
OOD的设计去解决问题, global variable -> tweetList and userHashMap
1. Create Addtional Class Tweet and User
2. Tweet class contains userId and tweetId
3. User class contains userId and a Set<Integer> follows that manages follower and followee
4. For each function, we need to check whether the user itself or follower/followee is created?
5. getNewsFeed
    We want the last 10 posts, so check TweetList, if the poster are user itself or people user follows, add
*/
class User {
    int userid;
    Set<Integer> follows;
    public User(int userid) {
        this.userid = userid;
        follows = new HashSet<>();
    }
}
class Tweet {
    int userid;
    int tweetid;
    public Tweet(int userid, int tweetid) {
        this.userid = userid;
        this.tweetid = tweetid;
    }
}

class Twitter {
    List<Tweet> tweetList;
    Map<Integer, User> userMap;

    public Twitter() {
        tweetList = new ArrayList<>();
        userMap = new HashMap<>();    
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        tweetList.add(new Tweet(userId, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        List<Integer> last10 = new ArrayList<>();
        int i = tweetList.size() - 1;
        while (last10.size() < 10 && i >= 0) {
            if (tweetList.get(i).userid == userId || userMap.get(userId).follows.contains(tweetList.get(i).userid)) {
                last10.add(tweetList.get(i).tweetid);
            }
            i--;
        }
        return last10;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        User user = userMap.get(followerId);
        user.follows.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        User user = userMap.get(followerId);
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