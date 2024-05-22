class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] freqArray = new int[26];
        for (char c : s.toCharArray()) {
            freqArray[c - 'a']++;
        }
        
        for (char c : t.toCharArray()) {
            freqArray[c - 'a']--;
        }

        for (int freq : freqArray) {
            if (freq != 0) {
                return false;
            }
        }
        return true;
    }
}