class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sbArr = new StringBuilder[numRows];
        for (int i = 0; i < sbArr.length; i++) {
            sbArr[i] = new StringBuilder();
        }

        int sIdx = 0;
        while (sIdx < s.length()) {
            int currentRow = 0;
            while (currentRow < numRows && sIdx < s.length()) {
                sbArr[currentRow].append(s.charAt(sIdx));
                sIdx++;
                currentRow++;
            }
            currentRow -= 2;
            while (currentRow > 0 && sIdx < s.length()) {
                sbArr[currentRow].append(s.charAt(sIdx));
                sIdx++;
                currentRow--;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sbArr.length; i++) {
            result.append(sbArr[i].toString());
        }
        return result.toString();
    }
}