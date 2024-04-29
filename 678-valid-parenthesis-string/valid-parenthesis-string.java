class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openBrackets = new Stack < > ();
        Stack<Integer> asterisks = new Stack < > ();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openBrackets.push(i);
            }
            else if (ch == '*') {
                asterisks.push(i);
            } else if (ch == ')') {
                if (!openBrackets.empty()) {
                    openBrackets.pop();
                } else if (!asterisks.isEmpty()) {
                    asterisks.pop();
                } else if (asterisks.isEmpty() && openBrackets.isEmpty()){
                    return false;
                }
            }
        }

        while (!openBrackets.isEmpty() && !asterisks.isEmpty()) {
            if (openBrackets.pop() > asterisks.pop()) {
                return false;
            }
        }

        return openBrackets.isEmpty();
    }
}