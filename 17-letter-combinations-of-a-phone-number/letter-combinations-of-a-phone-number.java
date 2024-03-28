class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0 || digits == null) {
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
        backTrack(digits, map, result, 0, sb);
        return result;
    }
    private void backTrack(String digits, Map<Character, String> map, List<String> result, int index, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String cor = map.get(digits.charAt(index));
        for (int i = 0; i < cor.length(); i++) {
            sb.append(cor.charAt(i));
            backTrack(digits, map, result, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}