//down: 0 to numRows - 1
//up: numRows - 2 to 1
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }

        boolean movingDown = true;
        int currentRow = 0;
        for (char c : s.toCharArray()) {
            sb[currentRow].append(c);
            if (currentRow == 0) {
                movingDown = true;
            }
            if (currentRow == numRows - 1) {
                movingDown = false;
            }
            currentRow += movingDown ? 1 : -1;
        }

        String result = "";
        for (StringBuilder S : sb) {
            result += S;
        }
        return result;
    }
}