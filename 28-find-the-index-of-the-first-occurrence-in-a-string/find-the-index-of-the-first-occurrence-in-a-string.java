class Solution {
    public int strStr(String haystack, String needle) {
        int slow = 0;
        for (int fast = 0; fast < haystack.length(); fast++) {
            if (fast - slow + 1 == needle.length()) {
                if (haystack.substring(slow, fast + 1).equals(needle)) {
                    return slow;
                }
                slow++;
            }
        }        
        return -1;
    }
}