class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            array[sChar - 'a']++;
            array[tChar - 'a']--;
        }
        for (int num : array) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}