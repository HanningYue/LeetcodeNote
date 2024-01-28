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
        backTrack(digits, map, result, sb, 0);
        return result;
    }
    private void backTrack(String digits, Map<Character, String> map, List<String> result,
    StringBuilder sb, int index)
    {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String correspondingChars = map.get(digits.charAt(index));
        for (int i = 0; i < correspondingChars.length(); i++) {
            sb.append(correspondingChars.charAt(i));
            backTrack(digits, map, result, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}