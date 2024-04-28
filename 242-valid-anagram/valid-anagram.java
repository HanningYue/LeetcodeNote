class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] countArr = new int[26];
        for (char c : s.toCharArray()) {
            countArr[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            countArr[c - 'a']--;
        }
        for (int freq : countArr) {
            if (freq != 0) {
                return false;
            }
        }
        return true;
    }
}