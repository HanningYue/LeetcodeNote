class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String firstString = strs[0];
        for (int i = 0; i < firstString.length(); i++) {
            char current = firstString.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String secondString = strs[j];
                if (i >= secondString.length() || current != secondString.charAt(i)) {
                    return firstString.substring(0, i);
                }
            }
        }
        return firstString;
    }
}