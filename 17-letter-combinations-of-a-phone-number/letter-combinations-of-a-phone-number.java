/**
1. Use String array save all corresponding digits and letters
2. Use String letters to save 3/4 current startIndex digits - '0'
3. for each letter in letters, backTracking, update String with each letter
*/

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>(); 
        if(digits.length() == 0){
            return ans;
        }
    
        HashMap<Character,String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        
        
        Findcombinations(digits,0,hm, new StringBuilder(), ans);
            return ans;
        
    }
    public static void Findcombinations(String digits, int i, HashMap<Character,String> hm, 
        StringBuilder st, List<String> ans){
        
        if(i == digits.length()){
            ans.add(st.toString());
            return;
        }
        
        String curr = hm.get(digits.charAt(i));
        
        for (int k=0;k<curr.length();k++){
            st.append(curr.charAt(k));
            Findcombinations(digits, i+1, hm, st, ans);
            st.deleteCharAt(st.length()-1);
        }
        
        
        
    }
    
}