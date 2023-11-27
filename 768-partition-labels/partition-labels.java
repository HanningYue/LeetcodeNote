/**
Form a window, we want to return the window size to a List<Integer>
    For each character in the window, we want to have the last appearance of the character
    Use a HashMap for this purpose, {character, last index}
    Iterate the string, form a window, UPDATE the rightMost pointer to ->
        the Math.max(rightMost pointer, the rightMost-most index of character in the window)
    Increase size of window and left pointer, while loop inside a while loop
*/
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int left = 0, rightMost = 0;
        
        while (left < s.length()) {
            int size = 0;
            rightMost = Math.max(rightMost, map.get(s.charAt(left)));
            while (left <= rightMost) {
                rightMost = Math.max(rightMost, map.get(s.charAt(left)));
                left++;
                size++;
            }
            result.add(size);
        }
        return result;
    }
}