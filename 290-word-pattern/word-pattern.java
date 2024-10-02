class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (strings.length != pattern.length()) {
            return false;
        }

        Map<Character, String> patternMap = new HashMap<>();
        Map<String, Character> sMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String str = strings[i];
            if (patternMap.containsKey(c) && !patternMap.get(c).equals(str)) {
                return false;
            }
            if (sMap.containsKey(str) && sMap.get(str) != c) {
                return false;
            }
            patternMap.put(c, str);
            sMap.put(str, c);
        }
        return true;
    }
}