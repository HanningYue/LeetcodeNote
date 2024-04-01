class Solution {
    Integer[][] dpTable;
    public int minDistance(String word1, String word2) {
        dpTable = new Integer[word1.length()][word2.length()];
        return dp(word1, word1.length() - 1, word2, word2.length() - 1);
    }
    private int dp(String word1, int index1, String word2, int index2) {
        if (index1 == -1) {
            return index2 + 1;
        } else if (index2 == -1) {
            return index1 + 1;
        }
        if (dpTable[index1][index2] != null) {
            return dpTable[index1][index2];
        }

        int skip = dp(word1, index1 - 1, word2, index2 - 1);
        int insert = dp(word1, index1, word2, index2 - 1) + 1;
        int delete = dp(word1, index1 - 1, word2, index2) + 1;
        int replace = dp(word1, index1 - 1, word2, index2 - 1) + 1;
        
        if (word1.charAt(index1) == word2.charAt(index2)) {
            dpTable[index1][index2] = skip;
        } else if (word1.charAt(index1) != word2.charAt(index2)) {
            dpTable[index1][index2] = Math.min(insert, Math.min(delete, replace));
        }
        
        return dpTable[index1][index2];
    }
}