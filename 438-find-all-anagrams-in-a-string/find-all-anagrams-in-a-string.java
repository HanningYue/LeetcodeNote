class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) 
            map.put(c, map.getOrDefault(c, 0) + 1);
        int slow = 0, fast = 0;
        while (fast < s.length()) {
            char c = s.charAt(fast);
            if (map.containsKey(c))
                map.put(c, map.get(c) - 1);
            if (allZero(map))
                result.add(slow);
            while (fast - slow + 1 == p.length()) {
                c = s.charAt(slow);
                if (map.containsKey(c))
                    map.put(c, map.get(c) + 1);
                slow++;
            }
            fast++;
        }
        return result;
    }
    private boolean allZero(Map<Character, Integer> map) {
        for (int value : map.values()) {
            if (value != 0) 
                return false;
        }
        return true;
    }
}