class Solution {
    List<String>[] dpTable;
    public List<String> wordBreak(String s, List<String> wordDict) {
        dpTable = new ArrayList[s.length()];
        Set<String> set = new HashSet<>(wordDict);
        return dp(s, set, 0);
    }
    private List<String> dp(String s, Set<String> set, int index) {
        List<String> result = new ArrayList<>();
        if (index == s.length()) {
            result.add("");
            return result;
        }
        if (dpTable[index] != null) {
            return dpTable[index];
        }
        for (int length = 1; length + index <= s.length(); length++) {
            String current = s.substring(index, index + length);

            if (set.contains(current)) {
                List<String> subList = dp(s, set, index + length);
                for (String subString : subList) {
                    if (subString.length() == 0) {
                        result.add(current);
                    } else {
                        result.add(current + " " + subString);
                    }
                }
            }
        }
        dpTable[index] = result;
        return dpTable[index];
    }
}