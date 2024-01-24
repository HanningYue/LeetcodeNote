class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> seen = new HashSet<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String current = s.substring(i, i + 10);
            if (seen.contains(current)) {
                set.add(current);
            } else {
                seen.add(current);
            }
        }
        return new ArrayList<>(set);
    }
}