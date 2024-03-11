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
        dfs(map, result, digits, sb, 0);
        return result;
    }
    private void dfs(Map<Character, String> map, List<String> result, String digits, StringBuilder sb, 
                    int index) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String corString = map.get(digits.charAt(index));
        for (int i = 0; i < corString.length(); i++) {
            sb.append(corString.charAt(i));
            dfs(map, result, digits, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}