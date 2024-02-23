class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i), tChar = t.charAt(i);
            if (mapS.containsKey(sChar) && mapS.get(sChar) != tChar) {
                return false;
            } else {
                mapS.put(sChar, tChar);
            }

            if (mapT.containsKey(tChar) && mapT.get(tChar) != sChar) {
                return false;
            } else {
                mapT.put(tChar, sChar);
            }
        }
        
        return true;
    }
}