class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> mapS = new HashMap<>();
        for (char c : s.toCharArray()) {
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
        }   
        return mapT.equals(mapS);
    }
}