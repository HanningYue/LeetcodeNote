class Solution {
    public boolean isAnagram(String s, String t) {
        int[] tChar = new int[26];
        for (char c : t.toCharArray()) {
            tChar[c - 'a']++;
        }

        int[] sChar = new int[26];
        for (char c : s.toCharArray()) {
            tChar[c - 'a']--;
        }
        for (int i = 0; i < tChar.length; i++) {
            if (tChar[i] != 0) {
                return false;
            }
        }
        return true;
    }
}