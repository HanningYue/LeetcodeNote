class Solution {
    List<String>[] dpTable;
    public List<String> wordBreak(String s, List<String> wordDict) {
        dpTable = new List[s.length()];
        Set<String> set = new HashSet<>(wordDict);
        return dp(s, 0, set);
    }
    private List<String> dp (String s, int index, Set<String> set) {
        List<String> result = new ArrayList<>();
        if (index == s.length()) {
            result.add("");
            return result;
        }
        if (dpTable[index] != null) {
            return dpTable[index];
        }
        for (int length = 1; length + index <= s.length(); length++) {
            String prefix = s.substring(index, index + length);
            if (set.contains(prefix)) {
                List<String> subproblem = dp(s, index + length, set);
                for (String sub : subproblem) {
                    if (sub.isEmpty()) {
                        result.add(prefix);
                    } else {
                        result.add(prefix + " " + sub);
                    }
                }
            }
        }
        dpTable[index] = result;
        return result;
    }
}