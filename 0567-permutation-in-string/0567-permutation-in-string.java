/*
Return boolean, FIXED-Size sliding window
1. Want to check the permutation, IN OTHER WORDS, want to make sure character and their frequency int s1 appears exactly in s2
2. For each character in s1, store their frequency in an Array
3. Iterate s2, for each character, minus the character frequency at fast by 1 in Array, when the size of window reaches length of s1 Check if frequency array s1 is empty (write helper function),  if so, return true, otherwise, add the character frequency at slow by 1 (offset)
*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] frequency = new int[26];
        for (char c : s1.toCharArray()) {
            frequency[c - 'a']++;
        }
        
        int slow = 0;
        for (int fast = 0; fast < s2.length(); fast++) {
            frequency[s2.charAt(fast) - 'a']--;
            
            if (fast - slow + 1 == s1.length()) {
                if (allZero(frequency)) {
                    return true;
                }
                frequency[s2.charAt(slow) - 'a']++;
                slow++;
            }
        }
        return false;
    }
    
    private boolean allZero(int[] arr) {
        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}