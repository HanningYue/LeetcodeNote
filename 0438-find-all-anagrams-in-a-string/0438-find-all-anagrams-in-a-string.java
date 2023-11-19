/*
Fixed-size sliding window, we maintain a window of size of String p
In the window, if frequency of p letters minus frequency of window letter equals 0
We reached an anagram
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        
        int match = 0;
        for (int fast = 0; fast < s.length(); fast++) { 
            char c = s.charAt(fast);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    match++;
                }
            }

            if (fast - p.length() >= 0) { 
                c = s.charAt(fast - p.length());
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) > 0) {
                        match--;
                    }
                }
            }
            
            if (match == p.length()) {
                result.add(fast - p.length() + 1);
            }
        }
        return result;
    }
}