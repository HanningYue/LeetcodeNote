class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String code = encode(str);
            map.putIfAbsent(code, new ArrayList<>());
            map.get(code).add(str);
        }

        List<List<String>> result = new ArrayList<>(map.values());
        return result;
    }

    public String encode(String str) {
        char[] count = new char[26];
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }
        return new String(count);
    }
}