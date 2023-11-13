/*
If we can flip k characters to the same character,consider this question alternative, what is the longest repeating character with at most k different character
Since we want to know the frequency of each character in the window, we can use a frequency[] to store all the character and update it in the window
1. Declare a frequency array, during each fast iteration, increase 1 of the character at fast
2. When fast - slow + 1 - maxFrequent is greater than k, it means we have more than k distinct characters exclude the most frequent character.
3. We need to remove the character at the slow. And minus the frequency of slow character by 1 for each iteration
4. Update the size of window each iteration
*/
class Solution {
    public int characterReplacement(String s, int k) {
        int[] frequency = new int[26];
        int maxLength = 0, maxFrequency = 0;
        int slow = 0;
        
        for (int fast = 0; fast < s.length(); fast++) {
            frequency[s.charAt(fast) - 'A']++;
            maxFrequency = Math.max(maxFrequency, frequency[s.charAt(fast) - 'A']);
            while (fast - slow + 1 - maxFrequency > k) {
                frequency[s.charAt(slow) - 'A']--;
                slow++;
            }
            maxLength = Math.max(maxLength, fast - slow + 1);
        }
        return maxLength;
    }
}