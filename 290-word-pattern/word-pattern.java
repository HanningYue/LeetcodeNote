class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] sArray = s.split(" ");
        if (pattern.length() != sArray.length) {
            return false;
        }
        
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> sMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char pChar = pattern.charAt(i);
            if (map.containsKey(pChar) && !map.get(pChar).equals(sArray[i])
            ||  sMap.containsKey(sArray[i]) && sMap.get(sArray[i]) != pChar) {
                return false;
            }
            map.put(pChar, sArray[i]);
            sMap.put(sArray[i], pChar);
        }
        return true;
    }
}