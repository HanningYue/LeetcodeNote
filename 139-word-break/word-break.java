class Solution {
    Boolean[] dpTable;
    public boolean wordBreak(String s, List<String> wordDict) {
        dpTable = new Boolean[s.length()];
        Set<String> set = new HashSet<>(wordDict);
        return dp(s, 0, set);
    }
    private boolean dp(String s, int index, Set<String> set) {
        if (index == s.length()) {
            return true;
        }
        if (dpTable[index] != null) {
            return dpTable[index];
        }
        for (int length = 1; index + length <= s.length(); length++) {
            String prefix = s.substring(index, index + length);
            if (set.contains(prefix)) {
                boolean subProblem = dp(s, index + length, set);
                if (subProblem) {
                    dpTable[index] = true;
                    return true;
                }
            }
        }
        dpTable[index] = false;
        return false;
    }
}