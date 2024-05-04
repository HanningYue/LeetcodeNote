class Solution {
    public boolean isAnagram(String s, String t) {
        int[] resultArray = new int[26];

        for (char c : s.toCharArray()) {
            resultArray[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            resultArray[c - 'a']--;
        }

        for (int value : resultArray) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}