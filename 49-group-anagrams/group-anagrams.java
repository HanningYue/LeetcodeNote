class Solution {
    Map<String, List<String>> map;
    public List<List<String>> groupAnagrams(String[] strs) {
        map = new HashMap<>();
        for (String str : strs) {
            countFreq(str);
        }
        List<List<String>> result = new ArrayList<>(map.values());
        return result;
    }
    private void countFreq(String str) {
        int[] frequencyArr = new int[26];
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            frequencyArr[c - 'a']++;
            
        }
        for (int num : frequencyArr) {
            sb.append(num).append("#");
        }
        String s = sb.toString();
        map.putIfAbsent(s, new ArrayList<>());
        map.get(s).add(str);
    }
}