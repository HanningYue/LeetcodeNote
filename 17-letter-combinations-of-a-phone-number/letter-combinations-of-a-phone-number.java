class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
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
        dfs(map, digits, 0, result, sb);
        return result;
    }
    private void dfs(Map<Character, String> map, String digits, int index, List<String> result, StringBuilder sb) 
    {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String corString = map.get(digits.charAt(index));
        for (int i = 0; i < corString.length(); i++) {
            sb.append(corString.charAt(i));
            dfs(map, digits, index + 1, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}