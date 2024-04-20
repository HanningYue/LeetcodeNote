class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        int length = 0;
        Set<String> set = new HashSet<>();
        for (String s : forbidden) {
            set.add(s);
            length = Math.max(length, s.length());
        }

        int n = word.length();
        int result = 0;
        for (int i = n - 1, right = n; right > result && i >= 0; i--) {
            int now = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < right && j - i < length; ++j) {
                sb.append(word.charAt(j));
                if (set.contains(sb.toString())) {
                    right = j;
                    break;
                }
            }
            result = Math.max(result, right - i);
        }
        return result;
    }
}