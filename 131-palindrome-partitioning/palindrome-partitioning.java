class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backTrack(result, list, 0, s);
        return result;
    }
    private void backTrack(List<List<String>> result, List<String> list, int index, String s) {
        if (index == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String current = s.substring(index, i + 1);
            if (isPalindrome(current)) {
                list.add(current);
                backTrack(result, list, i + 1, s);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}