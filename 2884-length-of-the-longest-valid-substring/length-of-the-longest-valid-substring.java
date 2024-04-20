class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        HashSet<String> set=new HashSet<>();
        for(String s:forbidden)
            set.add(s);
        
        int n=word.length();
        int ans=0;
        int i=0;
        int j=0;
        while(j<n){
            for(int k=j;k>j-10 && k>=i;k--){
                if(set.contains(word.substring(k,j+1))){
                    i=k+1;
                    break;
                }
            }
            ans=Math.max(j-i+1,ans);
            j++;
        }
        return ans;
    }
}