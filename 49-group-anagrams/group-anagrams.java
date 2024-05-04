class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] stringArray = str.toCharArray();
            
            Arrays.sort(stringArray);
            String sorted = new String(stringArray);

            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(str);
        }
        List<List<String>> result = new ArrayList<>(map.values());
        return result;
    }
}