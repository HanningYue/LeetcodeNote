class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int length = Integer.MIN_VALUE;
        int countOfDistinct = 0;
        
        for (int fast = 0; fast < s.length(); fast++) {
            map.put(s.charAt(fast), map.getOrDefault(s.charAt(fast), 0) + 1);
            if (map.get(s.charAt(fast)) == 1) {
                countOfDistinct++;
            }
            
            while (countOfDistinct > k) {
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