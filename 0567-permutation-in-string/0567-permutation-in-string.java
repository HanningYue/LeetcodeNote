class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] frequency = new int[26];
        for (char c : s1.toCharArray()) {
            frequency[c - 'a']++;
        }
        
        int slow = 0;
        for (int fast = 0; fast < s2.length(); fast++) {
            frequency[s2.charAt(fast) - 'a']--;
            if (allZero(frequency)) {
                return true;
            }
            
            while (fast - slow + 1 >= s1.length()) {
                frequency[s2.charAt(slow) - 'a']++;
                slow++;
            }
        }
        return false;
    }
    
    private boolean allZero(int[] arr) {
        for (int num : arr) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}