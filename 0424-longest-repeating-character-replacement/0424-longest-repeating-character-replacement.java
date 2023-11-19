/*
We can use array or hashmap to store the frequency
*/
class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int length = 0;
        int maxFreq = 0;
        
        for (int fast = 0; fast < s.length(); fast++) {
            char c = s.charAt(fast);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
            
            while (fast - slow + 1 - maxFreq > k) {
                map.put(s.charAt(slow), map.get(s.charAt(slow)) - 1);
                if (map.get(s.charAt(slow)) == 0) {
                    map.remove(s.charAt(slow));
                }
                slow++;
            }
            length = Math.max(length, fast - slow + 1);
        }
        return length;
    }
}