class Solution {
    public int strStr(String haystack, String needle) {
        int slow = 0, fast = 0;
        while (fast < haystack.length()) {
            if (fast - slow + 1 == needle.length()) {
                String current = haystack.substring(slow, fast + 1);
                if (current.equals(needle)) {
                    return slow;
                }
                slow++;
            }
            fast++;
        }
        return -1;
    }
}