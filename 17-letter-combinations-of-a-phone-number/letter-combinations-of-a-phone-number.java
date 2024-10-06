class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty() || digits.length() == 0) {
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

        backTrack(digits, map, 0, new StringBuilder(), result);
        return result;
    }

    private void backTrack(String digits, Map<Character, String> map, int index, StringBuilder sb, List<String> result) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String current = map.get(digits.charAt(index));
        for (char c : current.toCharArray()) {
            sb.append(c);
            backTrack(digits, map, index + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}