class Solution {
    Map<String, List<String>> map;
    public List<List<String>> groupAnagrams(String[] strs) {
        map = new HashMap<>();
        for (String str : strs) {
            encode(str);
        }
        return new ArrayList<>(map.values());
    }
    
    private void encode(String s) {
        char[] charArray = new char[26];
        for (char c : s.toCharArray()) {
            charArray[c - 'a']++;
        }
        String sorted = new String(charArray);
        map.putIfAbsent(sorted, new ArrayList<>());
        map.get(sorted).add(s);
    }
}