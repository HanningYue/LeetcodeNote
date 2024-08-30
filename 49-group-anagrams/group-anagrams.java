class Solution {
    Map<String, List<String>> map;
    public List<List<String>> groupAnagrams(String[] strs) {
        map = new HashMap<>();
        for (String s : strs) {
            encode(s);
        }
        return new ArrayList<>(map.values());
    }
    private void encode(String s) {
        char[] array = new char[26];
        for (char c : s.toCharArray()) {
            array[c - 'a']++;
        }
        String toString = new String(array);
        map.putIfAbsent(toString, new ArrayList<String>());
        map.get(toString).add(s);
    }
}