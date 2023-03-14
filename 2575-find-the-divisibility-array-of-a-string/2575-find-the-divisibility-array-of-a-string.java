class Solution {
    public int[] divisibilityArray(String word, int m) {
        StringBuilder sb = new StringBuilder("");
        
        int n = word.length();
        int[] ans = new int[n];
        long num;
        
        for(int ind=0; ind<n; ind++){
            sb.append(word.charAt(ind));
            num = Long.valueOf(sb.toString());
            
            if(num % m == 0){
                ans[ind] = 1;
            }
            else{
                ans[ind] = 0;
            }
            
            sb.setLength(0);
            sb.append((num%m));
        }
        
        return ans;
    }
}