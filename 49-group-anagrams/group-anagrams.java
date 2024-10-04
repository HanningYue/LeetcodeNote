class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String encoded = encode(s);
            map.putIfAbsent(encoded, new ArrayList<>());
            map.get(encoded).add(s);
        }
        return new ArrayList<>(map.values());
    }
    private String encode(String s) {
        int[] charArray = new int[26];
        for (char c : s.toCharArray()) {
            charArray[c - 'a']++;
        }
        String encoded = Arrays.toString(charArray);
        return encoded;
    }
}