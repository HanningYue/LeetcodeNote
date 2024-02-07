class Solution {
    private int[] dpTable;
    public boolean wordBreak(String s, List<String> wordDict) {
        dpTable = new int[s.length()];
        Arrays.fill(dpTable, -1);
        Set<String> set = new HashSet<>(wordDict);
        
        return dp(s, 0, set);
    }
    private boolean dp(String s, int index, Set<String> set) {
        if (index == s.length()) {
            return true;
        }
        if (dpTable[index] != -1) {
            return dpTable[index] == 0 ? false : true;
        }
        for (int length = 1; index + length <= s.length(); length++) {
            if (set.contains(s.substring(index, index + length))) {
                boolean subproblem = dp(s, index + length, set);
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