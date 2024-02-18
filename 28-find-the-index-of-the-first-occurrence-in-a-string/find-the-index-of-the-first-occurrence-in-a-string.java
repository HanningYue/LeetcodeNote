class Solution {
    public int strStr(String haystack, String needle) {
        Set<String> set = new HashSet<>();
        set.add(needle);

        int slow = 0, fast = needle.length();
        while (fast <= haystack.length()) {
            String sub = haystack.substring(slow, fast);
            if (set.contains(sub)) {
                return slow;
            }
            slow++;
            fast++;
        }
        return -1;
    }
}