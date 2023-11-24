
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
        backTracking(digits, result, sb, 0, map);
        return result;
    }
    private void backTracking(String digits, List<String> result, StringBuilder sb, int startIndex, 
        Map<Character, String> map)
    {
        if (startIndex == digits.length()) {
            result.add(new String(sb.toString()));
            return;
        }

        String digitChar = map.get(digits.charAt(startIndex));
        for (int i = 0; i < digitChar.length(); i++) {
            sb.append(digitChar.charAt(i));
            backTracking(digits, result, sb, startIndex + 1, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}