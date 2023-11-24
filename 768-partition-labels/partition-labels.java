/**
Form a window, we want to return the window size to a List<Integer>
    For each character in the window, we want to have the last appearance of the character
    Use a HashMap for this purpose, {character, last index}
    Iterate the string, form a window, UPDATE the right pointer to ->
        the Math.max(right pointer, the right-most index of character in the window)
    Increase size of window and left pointer, while loop inside a while loop
*/
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int left = 0, right = 0;
        while (left < s.length()) {
            int step = 0;
            right = Math.max(right, map.get(s.charAt(left)));
            while (left <= right) {
                right = Math.max(right, map.get(s.charAt(left)));
                left++;
                step++;
            }
            result.add(step);
        }
        return result;
    }
}