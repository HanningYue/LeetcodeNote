class Solution {
    public int strStr(String haystack, String needle) {
        Set<String> set = new HashSet<>();
        set.add(needle);
        int slow = 0, fast = 0;
        while (fast < haystack.length()) {
            if (fast - slow + 1 == needle.length()) {
                String sub = haystack.substring(slow, fast + 1);
                if (set.contains(sub)) {
                    return slow;
                }
                slow++;
            }
            fast++;
        }
        return -1;
    }
}