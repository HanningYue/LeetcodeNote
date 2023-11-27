/**
BackTracking, substring() is exclusive
helper function to check palindrome condition
*/
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backTracking(0, s, list, result);
        return result;
    }

    private void backTracking(int startIndex, String s, List<String> list, List<List<String>> result) {
        if (startIndex == s.length()) {
            result.add(new ArrayList(list));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                list.add(s.substring(startIndex, i + 1));
                backTracking(i + 1, s, list, result);
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