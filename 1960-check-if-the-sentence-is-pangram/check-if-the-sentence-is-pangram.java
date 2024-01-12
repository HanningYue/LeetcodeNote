class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] alphabet = new boolean[26];
        for (char c : sentence.toCharArray()) {
            alphabet[c - 'a'] = true;
        }
        for (boolean value : alphabet) {
            if (!value) {
                return false;
            }
        }
        return true;
    }
}