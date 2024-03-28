class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backTrack(s, 0, result, list);
        return result;
    }
    private void backTrack(String s, int index, List<List<String>> result, List<String> list) {
        if (index == s.length()) {
            result.add(new ArrayList<>(list));
        }
        for (int i = index; i < s.length(); i++) {
            if (!palindrome(s, index, i)) {
                continue;
            }
            list.add(s.substring(index, i + 1));
            backTrack(s, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }
    private boolean palindrome(String s, int left, int right) {
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