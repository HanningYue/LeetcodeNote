class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        if (digits == null || digits.length() == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        backTracking(result, sb, 0, digits, map);
        return result;
    }
    private void backTracking(List<String> result, StringBuilder sb, int start, 
    String digits, Map<Character, String> map) {
        if (start == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String digitChar = map.get(digits.charAt(start));
        for (int i = 0; i < digitChar.length(); i++) {
            sb.append(digitChar.charAt(i));
            backTracking(result, sb, start + 1, digits, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}