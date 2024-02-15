class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        Map<String, Character> smap = new HashMap<>();
        int i = 0, j = 0;
        while (i < pattern.length() && j < strings.length) {
            char pat = pattern.charAt(i);
            String cor = strings[j];
            if (map.containsKey(pat)) {
                if (!map.get(pat).equals(cor)) {
                    return false;
                }
            } 
            if (smap.containsKey(cor)) {
                if (!smap.get(cor).equals(pat)) {
                    return false;
                }
            }
            map.put(pat, cor);
            smap.put(cor, pat);
            i++;
            j++;
        }
        return true;
    }
}