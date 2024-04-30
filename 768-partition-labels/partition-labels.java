class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }
        
        List<Integer> result = new ArrayList<>();

        int furthest = 0;
        int left = 0;
        while (left < s.length()) {
            int size = 0;
            char currentChar = s.charAt(left);
            int rightMost = map.get(currentChar);
            furthest = Math.max(furthest, rightMost);

            while (left <= furthest) {
                currentChar = s.charAt(left);
                rightMost = map.get(currentChar);
                furthest = Math.max(furthest, rightMost);
                left++;
                size++;
            }
            result.add(size);
        }
        return result;
    }
}