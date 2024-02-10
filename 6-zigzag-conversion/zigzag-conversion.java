class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sbArr = new StringBuilder[numRows];
        for (int i = 0; i < sbArr.length; i++) {
            sbArr[i] = new StringBuilder();
        }

        int i = 0;
        while (i < s.length()) {
            int currentRow = 0;
            while (currentRow < numRows && i < s.length()) {
                sbArr[currentRow].append(s.charAt(i));
                i++;
                currentRow++;
            }
            currentRow -= 2;

            while (currentRow > 0 && i < s.length()) {
                sbArr[currentRow].append(s.charAt(i));
                i++;
                currentRow--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < sbArr.length; j++) {
            sb.append(sbArr[j].toString());
        }
        return sb.toString();
    }
}