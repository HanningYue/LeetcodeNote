class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> set = new HashSet<>();
        int maxLength = 0;
        for (String s : forbidden) {
            set.add(s);
            maxLength = Math.max(maxLength, s.length());
        }

        int result = 0;
        for (int leftMost = word.length() - 1, rightMost = word.length(); leftMost >= 0; leftMost--) {
            StringBuilder sb = new StringBuilder();
            for (int i = leftMost; i < rightMost && i - leftMost < maxLength; i++) {
                sb.append(word.charAt(i));
                if (set.contains(sb.toString())) {
                    rightMost = i;
                    break;
                }
            }
            result = Math.max(result, rightMost - leftMost);
        }
        return result;
    }
}