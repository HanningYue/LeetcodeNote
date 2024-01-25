class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Set<String> seen = new HashSet<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String sub = s.substring(i, i + 10);
            if (seen.contains(sub)) {
                set.add(sub);
            } else {
                seen.add(sub);
            }
        }
        for (String dna : set) {
            result.add(dna);
        }
        return result;
    }
}