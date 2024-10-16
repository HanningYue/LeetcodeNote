class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char current = s.charAt(i);
            int currentValue = map.get(current);
            
            if (i > 0) {
                char prev = s.charAt(i - 1);
                int prevValue = map.get(prev);
                if (currentValue > prevValue) {
                    result += currentValue - prevValue;
                    i--;
                    continue;
                }
            }
            
            result += currentValue;
        }
        return result;
    }
}