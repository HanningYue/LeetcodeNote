class Solution {
    Boolean[] dpTable;
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        dpTable = new Boolean[length];
        Set<String> set = new HashSet<>(wordDict);
        return dp(s, set, 0);
    }
    private boolean dp(String s, Set<String> set, int index) {
        if (index == s.length()) {
            return true;
        }
        if (dpTable[index] != null) {
            return dpTable[index];
        }
        for (int length = 1; index + length <= s.length(); length++) {
            String current = s.substring(index, index + length);
            if (set.contains(current)) {
                boolean subProblem = dp(s, set, index + length);
                if (subProblem) {
                    return true;
                }
            }
        }
        dpTable[index] = false;
        return dpTable[index];
    }
}