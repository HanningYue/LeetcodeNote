class Solution {
    Integer[] dpTable;
    public boolean wordBreak(String s, List<String> wordDict) {
        dpTable = new Integer[s.length()];
        Set<String> set = new HashSet<>(wordDict);
        return dp(s, 0, set);
    }
    private boolean dp(String s, int startIdx, Set<String> set) {
        if (startIdx == s.length()) {
            return true;
        }
        if (dpTable[startIdx] != null) {
            return dpTable[startIdx] == 1 ? true : false;
        }
        for (int length = 1; startIdx + length <= s.length(); length++) {
            String prefix = s.substring(startIdx, startIdx + length);
            if (set.contains(prefix)) {
                boolean sub = dp(s, startIdx + length, set);
                if (sub) {
                    dpTable[startIdx] = 1;
                    return true;
                }
            }
        }
        dpTable[startIdx] = 0;
        return false;
    }
}