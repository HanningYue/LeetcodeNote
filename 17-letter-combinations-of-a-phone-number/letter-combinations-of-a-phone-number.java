/**
All permutations, start each level at zero, increase the digits index by 1 for each iteration
digits[i] is a digit in the range ['2', '9']. So we can assume no '1' nor '0'
*/
class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        backTracking(result, sb, 0, digits, map);
        return result;
    }
    private void backTracking(List<String> result, StringBuilder sb, int startIndex, String digits,Map<Character, String> map) {
        if (startIndex == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String digitCharacters = map.get(digits.charAt(startIndex));
        for (int i = 0; i < digitCharacters.length(); i++) {
            sb.append(digitCharacters.charAt(i));
            backTracking(result, sb, startIndex + 1, digits, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}