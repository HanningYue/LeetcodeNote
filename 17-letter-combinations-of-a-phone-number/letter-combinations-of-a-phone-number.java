class Solution {
    Map<Character, String> map;
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backTrack(digits, 0, result, new StringBuilder());
        return result;
    }
    private void backTrack(String digits, int index, List<String> result, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String current = map.get(digits.charAt(index));
        for (int i = 0; i < current.length(); i++) {
            sb.append(current.charAt(i));
            backTrack(digits, index + 1, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}