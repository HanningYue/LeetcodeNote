class Solution {
    Boolean[] dpTable;
    public boolean wordBreak(String s, List<String> wordDict) {
        dpTable = new Boolean[s.length()];
        Set<String> dict = new HashSet<>(wordDict);
        return dp(s, 0, dict);
    }
    private boolean dp(String s, int index, Set<String> dict) {
        if (index == s.length()) {
            return true;
        }
        if (dpTable[index] != null) {
            return dpTable[index];
        }
        for (int length = 1; index + length <= s.length(); length++) {
            String prefix = s.substring(index, index + length);
            if (dict.contains(prefix)) {
                boolean sub = dp(s, index + length, dict);
                if (sub) {
                    dpTable[index] = true;
                    return true;
                }
            }
        }
        dpTable[index] = false;
        return false;
    }
}