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
            if (i - 1 >= 0) {
                char currentChar = s.charAt(i);
                char prevChar = s.charAt(i - 1);

                int current = map.get(currentChar);
                int prev = map.get(prevChar);
                
                if (prev < current) {
                    result += current - prev;
                    i--;
                } else {
                    result += current;
                }
            } else {
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }
}