/**
All permutations, start each level at zero, increase the digits index by 1 for each iteration
digits[i] is a digit in the range ['2', '9']. So we can assume no '1' nor '0'
*/
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuilder sb = new StringBuilder();
        backTracking(digits, map, 0, result, sb);
        return result;
    }
    private void backTracking(String digits, Map<Character, String> map, int startIndex, 
    List<String> result, StringBuilder sb)
    {
        if (startIndex == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String numberRepresent = map.get(digits.charAt(startIndex));
        for (int i = 0; i < numberRepresent.length(); i++) {
            sb.append(numberRepresent.charAt(i));
            backTracking(digits, map, startIndex + 1, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}