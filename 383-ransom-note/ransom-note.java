class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : magazine.toCharArray()) {
            if (map.containsKey(c)) {
                if (map.get(c) == 0) {
                    continue;
                }
                map.put(c, map.get(c) - 1);
            }
        }

        for (int value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}