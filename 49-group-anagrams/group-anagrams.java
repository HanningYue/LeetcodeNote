class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String encoded = encode(str);
            map.putIfAbsent(encoded, new ArrayList<>());
            map.get(encoded).add(str);
        }

        List<List<String>> result = new ArrayList<>(map.values());
        return result;
    }
    private String encode(String s) {
        char[] count = new char[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        return new String(count);
    }
}