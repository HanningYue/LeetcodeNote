/*

*/
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int match = 0;
        int slow = 0;
        int length = Integer.MAX_VALUE;
        String result = "";
        
        for (int fast = 0; fast < s.length(); fast++) {
            char current = s.charAt(fast);
            if (map.containsKey(current)) {
                map.put(current, map.get(current) - 1);
                if (map.get(current) >= 0) {
                    match++;
                }
            }
            
            while (match == t.length()) {
                if (fast - slow + 1 < length) {
                    length = fast - slow + 1;
                    result = s.substring(slow, fast + 1);
                }
                
                current = s.charAt(slow);
                if (map.containsKey(current)) {
                    map.put(current, map.get(current) + 1);
                    if (map.get(current) > 0) {
                        match--;
                    }
                }
                slow++;
            }
        }
        return result;
    }
}