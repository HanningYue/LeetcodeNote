/**
1. Use String array save all corresponding digits and letters
2. Use String letters to save 3/4 current startIndex digits - '0'
3. for each letter in letters, backTracking, update String with each letter
*/

class Solution {
    //0, 1, 2, 3, ... 9
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
     "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backTracking(result, digits, "", 0);
        return result;
    }
    private void backTracking(List<String> result, String digits, String path, int startIndex) {
        if (startIndex == digits.length()) {
            result.add(new String(path));
            return;
        }

        String letters = KEYS[digits.charAt(startIndex) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            backTracking(result, digits, path + letters.charAt(i), startIndex + 1);
        }
    }
}