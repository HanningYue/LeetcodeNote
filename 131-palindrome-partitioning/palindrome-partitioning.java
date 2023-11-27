/**
BackTracking, substring() is exclusive
helper function to check palindrome condition
*/
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backTracking(result, list, 0, s);
        return result;
        
    }
    private void backTracking(List<List<String>> result, List<String> list, int startIndex, String s) {
        if (startIndex == s.length()) {
            result.add(new ArrayList(list));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                list.add(s.substring(startIndex, i + 1));
                backTracking(result, list, i + 1, s);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}