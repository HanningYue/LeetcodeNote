class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        for (char c : s.toCharArray()) {
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!mapS.containsKey(c)) {
                return false;
            }
            mapS.put(c, mapS.get(c) - 1);
        }
        for (int value : mapS.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}