/*
( first, increase count
) first, minus left count, if no left, need to add ( -> increase right count
result need to add both count of ( and count of ) in case of unbalance
*/
class Solution {
    public int minAddToMakeValid(String s) {
        int numberOfLeft = 0;
        int needToInsertRight = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                numberOfLeft++;
            } 
            else if (c == ')'){
                numberOfLeft--;
                if (numberOfLeft < 0) {
                    needToInsertRight++;
                    numberOfLeft = 0;
                }
            }
        }
        int result = 0;
        result = result + numberOfLeft + needToInsertRight;
        return result;
    }
}