class Solution {
    public boolean isAnagram(String s, String t) {
        int[] result = new int[26];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (char c : sArr) {
            result[c - 'a']++;
        }
        for (char c : tArr) {
            result[c - 'a']--;
        }
        for (int n : result) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
}