class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] sArr = new char[26];
            for (char c : s.toCharArray()) {
                sArr[c - 'a']++;
            }
            String key = String.valueOf(sArr);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        for (List<String> value : map.values()) {
            result.add(value);
        }
        return result;
    }
}