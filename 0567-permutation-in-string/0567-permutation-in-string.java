/*
Return boolean
Want to check the permutation, IN OTHER WORDS, want to make sure the character and frequency of s1 appears in s2
For each character in s1, store their frequency in an Array
Iterate s2, for each character, minus the frequency in Array s1
if frequency array s1 is empty, return true, otherwise, return false
*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] frequencyArr = new int[26];
        for (char c : s1.toCharArray()) {
            frequencyArr[c - 'a']++;
        }

        int start = 0;
        for (int end = 0; end < s2.length(); end++) {
            // Decrease the frequency of the current character
            frequencyArr[s2.charAt(end) - 'a']--;

            // If the window size is equal to s1.length, check if we have a permutation
            if (end - start + 1 == s1.length()) {
                if (allZeros(frequencyArr)) {
                    return true;
                }
                // Increase the frequency of the character at the start of the window, then slide the window
                frequencyArr[s2.charAt(start) - 'a']++;
                start++;
            }
        }

        return false;
    }

    private boolean allZeros(int[] arr) {
        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
