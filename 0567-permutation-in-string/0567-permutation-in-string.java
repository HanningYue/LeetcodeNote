class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] frequency = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            frequency[s1.charAt(i) - 'a']++;
        }
        
        int slow = 0;
        for (int fast = 0; fast < s2.length(); fast++) {
            frequency[s2.charAt(fast) - 'a']--;
            if (arrayZero(frequency)) {
                return true;
            }        
            
            if (fast - slow + 1 == s1.length()) {
                frequency[s2.charAt(slow) - 'a']++;
                slow++;
            }
        }
        return false;
    }
    
    private boolean arrayZero(int[] arr) {
        for (int num : arr) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}