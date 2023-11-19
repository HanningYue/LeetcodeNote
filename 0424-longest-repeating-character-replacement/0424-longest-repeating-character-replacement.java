class Solution {
    public int characterReplacement(String s, int k) {
        int[] frequency = new int[26];
        int length = 0;
        int maxFreq = 0;
        
        int slow = 0;
        for (int fast = 0; fast < s.length(); fast++) {
            frequency[s.charAt(fast) - 'A']++;
            maxFreq = Math.max(maxFreq, frequency[s.charAt(fast) - 'A']);
            
            while (fast - slow + 1 - maxFreq > k) {
                frequency[s.charAt(slow) - 'A']--;
                slow++;
            }
            length = Math.max(length, fast - slow + 1);
        }
        return length;
    }
}