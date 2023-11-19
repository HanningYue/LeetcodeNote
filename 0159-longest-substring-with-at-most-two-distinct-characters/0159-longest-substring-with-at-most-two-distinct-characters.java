/*
1. We need a hashmap to store the character and their according frequency
2. Sliding window, update the frequency of fast character to map for each iteration, when frequency is equal to 1, increase the count of distinct character in our window
3. when count exceeds 2, remove character at slow from map, decrease the frequency, if frequency reaches 0, minus the count of distinct character in our window. Increase slow pointer each iteration
*/
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int countOfDistinct = 0;
        int length = Integer.MIN_VALUE;
        
        for (int fast = 0; fast < s.length(); fast++) {
            map.put(s.charAt(fast), map.getOrDefault(s.charAt(fast), 0) + 1);
            if (map.get(s.charAt(fast)) == 1) {
                countOfDistinct++;
            }
            
            while (countOfDistinct > 2) {
                map.put(s.charAt(slow), map.get(s.charAt(slow)) - 1);
                if (map.get(s.charAt(slow)) == 0) {
                    countOfDistinct--;
                }
                slow++;
            }
            
            length = Math.max(length, fast - slow + 1);
        }
        return length;
    }
}