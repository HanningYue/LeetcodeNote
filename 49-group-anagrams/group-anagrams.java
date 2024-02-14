class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);

            String sorted = new String(charArray);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(s);
        }
        for (List<String> value : map.values()) {
            result.add(value);
        }
        return result;
    }
}