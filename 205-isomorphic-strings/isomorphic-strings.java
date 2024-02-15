class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        int i = 0;
        while (i < s.length()) {
            char sChar = s.charAt(i), tChar = t.charAt(i);
            
            if (sMap.containsKey(sChar)) {
                if (!sMap.get(sChar).equals(tChar)) {
                    return false;
                }
            }
            
            if (tMap.containsKey(tChar)) {
                if (!tMap.get(tChar).equals(sChar)) {
                    return false;
                }
            }
            sMap.put(sChar, tChar);
            tMap.put(tChar, sChar);
            i++;
        }
        return true;
    }
}