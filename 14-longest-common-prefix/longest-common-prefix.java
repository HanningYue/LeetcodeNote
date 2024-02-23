class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 0; i < prefix.length(); i++) {
            char current = prefix.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String nextString = strs[j];
                if (i >= nextString.length() || current != nextString.charAt(i)) {
                    return prefix.substring(0, i);
                }
            }
        }
        return prefix;
    }
}