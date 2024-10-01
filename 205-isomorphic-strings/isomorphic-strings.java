class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> tMap = new HashMap<>();
        Map<Character, Character> sMap = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (tMap.containsKey(tChar) && tMap.get(tChar) != sChar) {
                return false;
            }
            if (sMap.containsKey(sChar) && sMap.get(sChar) != tChar) {
                return false;
            }
            tMap.put(tChar, sChar);
            sMap.put(sChar, tChar);
        }
        return true;
    }
}