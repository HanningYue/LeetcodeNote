class Solution {
    Boolean[] dpTable;
    public boolean wordBreak(String s, List<String> wordDict) {
        dpTable = new Boolean[s.length()];
        HashSet<String> set = new HashSet<>(wordDict);
        return dp(s, 0, set);
    }
    private boolean dp(String s, int index, HashSet<String> set) {
        if (index == s.length()) {
            return true;
        }
        if (dpTable[index] != null) {
            return dpTable[index];
        }

        for (int length = 1; length + index <= s.length(); length++) {
            String current = s.substring(index, length + index);
            if (set.contains(current)) {
                boolean subProblem = dp(s, index + length, set);
                if (subProblem) {
                    dpTable[index] = true;
                    return dpTable[index];
                }
            }
        }
        dpTable[index] = false;

        return dpTable[index];
    }
}