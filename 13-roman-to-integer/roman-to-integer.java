/**
IV IX  XL  XC  CD   CM
4   9  40  90  400  900
*/
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
        
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        int result = 0;
        while (!stack.isEmpty()) {
            char current = stack.pop();
            if (!stack.isEmpty()) {
                if ((current == 'V' || current == 'X') && stack.peek() == 'I') {
                    result += current == 'X' ? 9 : 4;
                    stack.pop();
                } else if ((current == 'L' || current == 'C') && stack.peek() == 'X') {
                    result += current == 'L' ? 40 : 90;
                    stack.pop();
                } else if ((current == 'D' || current == 'M') && stack.peek() == 'C') {
                    result += current == 'D' ? 400 : 900;
                    stack.pop();
                } else {
                    result += map.get(current);
                }
            } else {
                result += map.get(current);
            }
        }
        return result;
    }
}