/**

*/
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backTracking(result, s, list, 0);
        return result;
    }

    private void backTracking(List<List<String>> result, String s, 
    List<String> list, int startIndex)
    {
        if (startIndex == s.length()) {
            result.add(new ArrayList(list));
            return;
        }

        for (int i = startIndex + 1; i <= s.length(); i++) {
            if (valid(s.substring(startIndex, i))) {
                list.add(s.substring(startIndex, i));
                backTracking(result, s, list, i);
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