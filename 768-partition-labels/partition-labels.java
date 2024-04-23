class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int left = 0, right = 0;
        while (left < s.length()) {
            char currentChar = s.charAt(left);
            right = Math.max(right, map.get(currentChar));

            int size = 0;
            while (left <= right) {
                currentChar = s.charAt(left);
                right = Math.max(right, map.get(currentChar));
                left++;
                size++;
            }
            result.add(size);
        }
        return result;
    }
}