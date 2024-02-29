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
        dfs(digits, 0, result, sb, map);
        return result;
    }

    private void dfs(String digits, int index, List<String> result, StringBuilder sb,
    Map<Character, String> map) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String alignChar = map.get(digits.charAt(index));
        for (int i = 0; i < alignChar.length(); i++) {
            sb.append(alignChar.charAt(i));
            dfs(digits, index + 1, result, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}