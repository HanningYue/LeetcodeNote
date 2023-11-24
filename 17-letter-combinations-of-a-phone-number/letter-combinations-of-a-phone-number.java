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
        backTracking(digits, sb, map, result, 0);
        return result;
    }
    private void backTracking(String digits, StringBuilder sb, Map<Character, String> map, 
        List<String> result, int startIndex)
    {
        if (startIndex == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String digitCharacter = map.get(digits.charAt(startIndex));
        for (int i = 0; i < digitCharacter.length(); i++) {
            sb.append(digitCharacter.charAt(i));
            backTracking(digits, sb, map, result, startIndex + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}