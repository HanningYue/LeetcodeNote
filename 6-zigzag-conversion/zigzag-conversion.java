class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean movingDown = true;
        for (char c : s.toCharArray()) {
            sb[currentRow].append(c);
            if (currentRow == 0) {
                movingDown = true;
            } else if (currentRow == numRows - 1) {
                movingDown = false;
            }
            
            currentRow += movingDown ? 1 : -1;
        }

        String result = "";
        for (StringBuilder str : sb) {
            result += str.toString();
        }
        return result;
    }
}