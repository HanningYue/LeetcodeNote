class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        int slow = 0;
        for (int fast = 0; fast < haystack.length(); fast++) {
            if (fast - slow + 1 == needle.length()) {
                String sub = haystack.substring(slow, fast + 1);
                if (sub.equals(needle)) {
                    return slow;
                }
                slow++;
            }
        }
        return -1;
    }
}