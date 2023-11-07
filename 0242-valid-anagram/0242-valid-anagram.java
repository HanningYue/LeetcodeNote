class Solution {
    public boolean isAnagram(String s, String t) {
        int[] s_arr = new int[26];
        int[] t_arr = new int[26];
        
        for (char sChar : s.toCharArray()) {
            s_arr[sChar - 'a']++;    
        }
        for (char tChar : t.toCharArray()) {
            t_arr[tChar - 'a']++;
        }
        
        return Arrays.equals(s_arr, t_arr);
    }
}