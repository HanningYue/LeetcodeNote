class Solution {
    private int[] dpTable;
    public boolean wordBreak(String s, List<String> wordDict) {
        dpTable = new int[s.length()];
        Arrays.fill(dpTable, -1);
        Set<String> set = new HashSet<>(wordDict);
        return dp(s, set, 0);
    }

    private boolean dp(String s, Set<String> set, int index) {
        if (index == s.length()) {
            return true;
        }
        if (dpTable[index] != -1) {
            return dpTable[index] == 0 ? false : true;
        }
        for (int length = 1; index + length <= s.length(); length++) {
            String prefix = s.substring(index, index + length);
            if (set.contains(prefix)) {
                boolean subproblem = dp(s, set, index + length);
                if (subproblem == true) {
                    dpTable[index] = 1;
                    return true;
                }
            }
        }
        dpTable[index] = 0;
        return false;
    }
}