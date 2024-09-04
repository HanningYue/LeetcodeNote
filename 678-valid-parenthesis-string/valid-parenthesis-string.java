class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> star = new Stack<>();
        Stack<Integer> left = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(') {
                left.add(i);
            } else if (current == '*') {
                star.add(i);
            } else if (current == ')') {
                if (left.isEmpty() && star.isEmpty()) {
                    return false;
                } else if (!left.isEmpty()) {
                    left.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                }
            }
        }

        while (!left.isEmpty() && !star.isEmpty()) {
            if (left.pop() > star.pop()) {
                return false;
            }
        }

        if (!left.isEmpty()) {
            return false;
        }
        
        return true;
    }
}