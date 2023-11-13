/*
For each character in t, use map save their character and frequency
Iterate String s, for each appeared character, minus map frequency by 1, if the frequency is greater than 0. Increase match
When match is equals to t length, update length to the current sliding window size, update substring
If character exists in map. Increase map frequency by 1, if it is greater than 0 , minus match by 1. Return result
*/
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int match = 0, slow = 0, length = Integer.MAX_VALUE;
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
                if (length > fast - slow + 1) {
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