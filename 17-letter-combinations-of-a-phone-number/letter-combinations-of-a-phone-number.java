/**
1. Use String array save all corresponding digits and letters
2. Use String letters to save 3/4 current startIndex digits - '0'
3. for each letter in letters, backTracking, update String with each letter
*/

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>(); 
        if (digits.length() == 0){
            return result;
        }
    
        HashMap<Character,String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        StringBuilder sb = new StringBuilder();
        backTracking(digits, 0, map, sb, result);
            return result;
        
    }
    public static void backTracking(String digits, int startIndex, HashMap<Character,String> map, 
        StringBuilder sb, List<String> result)
        {
        if (startIndex == digits.length()){
            result.add(sb.toString());
            return;
        }
        
        String current = map.get(digits.charAt(startIndex));
        for (int i = 0; i < current.length(); i++){
            sb.append(current.charAt(i));
            backTracking(digits, startIndex + 1, map, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}