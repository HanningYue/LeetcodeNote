/*
For each character in t, use map save their character and frequency
Iterate String s, for each appeared character, minus map frequency by 1, if the frequency is greater than 0. Increase match
While match is equals to t length, update length to the current sliding window size, update substring.
If slow character exists in map. Increase map frequency by 1, if it is greater than 0 , minus match by 1.  Increase slow pointer while match == t.length();
Return result
*/
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int length = Integer.MAX_VALUE;
        int match = 0;
        int slow = 0;
        String result = "";
        for (int fast = 0; fast < s.length(); fast++) {
            char c = s.charAt(fast);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    match++;
                }
            }

            while (match == t.length()) {
                if (fast - slow + 1 < length) {
                    length = fast - slow + 1;
                    result = s.substring(slow, slow + length);
                }
                c = s.charAt(slow);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) > 0) {
                        match--;
                    }
                }
                slow++;
            }
        }
        return result;
    }
}