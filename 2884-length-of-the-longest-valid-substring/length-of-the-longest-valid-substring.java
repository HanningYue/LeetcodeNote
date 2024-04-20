class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> set = new HashSet<>();
        for (String s : forbidden) {
            set.add(s);
        }

        int slow = 0, fast = 0;
        int result = 0;
        while (fast < word.length()) {
            for (int i = fast; i > fast - 10 && i >= slow; i--) {
                if (set.contains(word.substring(i, fast + 1))) {
                    slow = i + 1;
                    break;
                }
            }
            result = Math.max(result, fast - slow + 1);
            fast++;
        }
        return result;
    }
}