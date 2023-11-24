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
    public static void backTracking(String digits, int i, HashMap<Character,String> map, 
        StringBuilder st, List<String> result){
        
        if(i == digits.length()){
            result.add(st.toString());
            return;
        }
        
        String curr = map.get(digits.charAt(i));
        
        for (int k=0;k<curr.length();k++){
            st.append(curr.charAt(k));
            backTracking(digits, i+1, map, st, result);
            st.deleteCharAt(st.length()-1);
        }
        
        
        
    }
    
}