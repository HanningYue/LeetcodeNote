class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            map.put(current, i);
        }

        List<Integer> result = new ArrayList<>();
        int furthest = 0;
        int pointer = 0;
        while (pointer < s.length()) {
            char currentChar = s.charAt(pointer);
            int furthestIndex = map.get(currentChar);
            furthest = Math.max(furthest, furthestIndex);

            int size = 0;
            while (pointer <= furthest) {
                currentChar = s.charAt(pointer);
                furthestIndex = map.get(currentChar);
                furthest = Math.max(furthest, furthestIndex);
                pointer++;
                size++;
            }
            result.add(size);
        }
        return result;
    }
}