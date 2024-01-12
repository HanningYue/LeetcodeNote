class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int left = 0, right = s.length() - 1;
        int firstHalfCount = 0, secondHalfCount = 0;
        while (left < right) {
            char first = s.charAt(left), second = s.charAt(right);
            if (set.contains(first)) {
                firstHalfCount++;
            }
            if (set.contains(second)) {
                secondHalfCount++;
            }
            left++;
            right--;
        }
        return firstHalfCount == secondHalfCount;
    }
}