class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            String sorted = String.valueOf(charArray);
            map.putIfAbsent(sorted, new ArrayList<String>());
            map.get(sorted).add(str);
        }

        List<List<String>> result = new ArrayList<>(map.values());
        return result;
    }
}