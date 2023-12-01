class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sChar = new int[26];
        int[] tChar = new int[26];
        for (char c : s.toCharArray()) {
            sChar[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            tChar[c - 'a']++;
        }
        return Arrays.equals(sChar, tChar);
    }
}