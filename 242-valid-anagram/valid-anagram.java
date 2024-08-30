class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] result = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            result[sChar - 'a']++;
            
            char tChar = t.charAt(i);
            result[tChar - 'a']--;
        }
        
        for (int value : result) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}