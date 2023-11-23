class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backTracking(s, 0, result, list);
        return result;
    }

    private void backTracking(String s, int startIndex, List<List<String>> result,
    List<String> list)
    {
        if (startIndex == s.length()) {
            result.add(new ArrayList(list));
            return;
        }

        for (int i = startIndex + 1; i <= s.length(); i++) {
            if (valid(s.substring(startIndex, i))) {
                list.add(s.substring(startIndex, i));
                backTracking(s, i, result, list);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean valid(String s) {
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