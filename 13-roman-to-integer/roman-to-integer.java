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
        int i = s.length() - 1;
        while (i >= 0) {
            char currentChar = s.charAt(i);
            int current = map.get(currentChar);
            
            if (i - 1 >= 0) {
                char prevChar = s.charAt(i - 1);
                int prev = map.get(prevChar);
                if (prev < current) {
                    result += current - prev;
                    i--;
                } else {
                    result += current;
                }
            } 
            else {
                result += current;
            }
            
            i--;
        }
        return result;
    }
}