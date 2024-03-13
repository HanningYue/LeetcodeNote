class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backTrack(result, list, s, 0);
        return result;
    }
    private void backTrack(List<List<String>> result, List<String> list, String s, int startIdx) {
        if (startIdx == s.length()) {
            result.add(new ArrayList<>(list));
        }
        for (int i = startIdx; i < s.length(); i++) {
            if (isPalindrome(s, startIdx, i)) {
                list.add(s.substring(startIdx, i + 1));
                backTrack(result, list, s, i + 1);
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