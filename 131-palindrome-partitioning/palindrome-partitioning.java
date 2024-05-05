class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();    
        List<String> list = new ArrayList<>();
        backTrack(s, result, list, 0);
        return result;
    }
    private void backTrack(String s, List<List<String>> result, List<String> list, 
    int index) {
        if (index == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String current = s.substring(index, i + 1);
            if (isPalindrome(current)) {
                list.add(current);
                backTrack(s, result, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
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