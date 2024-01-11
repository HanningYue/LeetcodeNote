class Solution {
    public String longestNiceSubstring(String s) {
        if (s == null || s.length() <= 1) {
            return "";
        }
        if (isNice(s)) {
            return s;
        }
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (isNice(substring) && substring.length() > longest.length()) {
                    longest = substring;
                }
            }
        }
        return longest;
    }

    private boolean isNice(String s) {
        int[] charMap = new int[128];
        for (char c : s.toCharArray()) {
            charMap[c]++;
        }
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c) && charMap[Character.toUpperCase(c)] == 0
                || Character.isUpperCase(c) && charMap[Character.toLowerCase(c)] == 0) {
                return false;
            }
        }
        return true;
    }
}
