class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int result = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentValue = map.get(currentChar);

            if (i > 0) {
                char prevChar = s.charAt(i - 1);
                int preValue = map.get(prevChar);

                if (currentValue > preValue) {
                    result += currentValue - preValue;
                    i--;
                } else {
                    result += currentValue;
                }
            } else {
                result += currentValue;
            }
        }
        return result;
    }
}