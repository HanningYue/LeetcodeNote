class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sbArray = new StringBuilder[numRows];
        for (int i = 0; i < sbArray.length; i++) {
            sbArray[i] = new StringBuilder();
        }

        int sIndex = 0;
        while (sIndex < s.length()) {
            int currentRow = 0;
            while (currentRow < numRows && sIndex < s.length()) {
                sbArray[currentRow].append(s.charAt(sIndex));
                sIndex++;
                currentRow++;
            }
            currentRow = currentRow - 2;
            while (currentRow > 0 && sIndex < s.length()) {
                sbArray[currentRow].append(s.charAt(sIndex));
                sIndex++;
                currentRow--;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : sbArray) {
            result.append(row.toString());
        }
        return result.toString();
    }
}