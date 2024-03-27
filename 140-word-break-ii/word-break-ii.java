class Solution {
    List<String>[] dpTable;
    public List<String> wordBreak(String s, List<String> wordDict) {
        dpTable = new ArrayList[s.length()];
        Set<String> dict = new HashSet<>(wordDict);
        return dp(s, 0, dict);
    }
    private List<String> dp(String s, int index, Set<String> dict) {
        List<String> result = new ArrayList<>();
        if (index == s.length()) {
            result.add("");
            return result;
        }
        if (dpTable[index] != null) {
            return dpTable[index];
        }
        for (int length = 1; index + length <= s.length(); length++) {
            String prefix = s.substring(index, index + length);
            if (dict.contains(prefix)) {
                List<String> subList = dp(s, index + length, dict);
                for (String subStr : subList) {
                    if (subStr.isEmpty()) {
                        result.add(prefix);
                    } else {
                        result.add(prefix + " " + subStr);
                   }
                }
            }
        }
        dpTable[index] = result;
        return result;
    }
}