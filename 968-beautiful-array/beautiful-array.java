class Solution {
    public int[] beautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        ans.add(1);
        
        while (ans.size() < n) {
            ArrayList<Integer> temp = new ArrayList<>();
            // odd
            for (int i = 0; i < ans.size(); i++) {
                 if (ans.get(i) * 2 - 1 <= n) {
                     temp.add(ans.get(i) * 2 - 1);
                 }
            } 
               
            // even
            for (int i = 0; i < ans.size(); i++) {
                 if (ans.get(i) * 2 <= n) {
                     temp.add(ans.get(i) * 2);
                 } 
            }
            ans = temp;
        }
        
        int len = ans.size();
        int []result = new int[len];
        
        for (int i = 0; i < len; i++) {
            result[i] = ans.get(i);
        }
        
        return result;
    }
}