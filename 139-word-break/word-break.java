class Solution {
    Boolean[] dpTable;
    public boolean wordBreak(String s, List<String> wordDict) {
        dpTable = new Boolean[s.length()];
        Set<String> set = new HashSet<>(wordDict);
        return dp(set, s, 0);
    }
    private boolean dp(Set<String> set, String s, int index) {
        if (index == s.length()) {
            return true;
        }
        if (dpTable[index] != null) {
            return dpTable[index];
        }
        for (int length = 1; length + index <= s.length(); length++) {
            String prefix = s.substring(index, index + length);
            if (set.contains(prefix)) {
                boolean subProblem = dp(set, s, index + length);
                if (subProblem) {
                    return true;
                }
            }
        }
        dpTable[index] = false;
        return dpTable[index];
    }
}