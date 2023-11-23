class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backTracking(s, result, list, 0);
        return result;
    }
    
    private void backTracking(String s, List<List<String>> result, List<String> list, 
    int startIndex) 
    {
        if (startIndex == s.length()) {
            result.add(new ArrayList(list));
        }    
        for (int i = startIndex + 1; i <= s.length(); i++) {
            if (valid(s.substring(startIndex, i))) {
                list.add(s.substring(startIndex, i));
                backTracking(s, result, list, i);
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