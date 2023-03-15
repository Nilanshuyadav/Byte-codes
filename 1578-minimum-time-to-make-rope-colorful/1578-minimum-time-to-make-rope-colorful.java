class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int total=0, max=Integer.MIN_VALUE, ans=0;
        
        for(int ind=0; ind<n; ind++){
            if(ind!=n-1 && colors.charAt(ind) == colors.charAt(ind+1)){
                total += neededTime[ind];
                max = Math.max(max, neededTime[ind]);
            }
            else{
                total += neededTime[ind];
                max = Math.max(max, neededTime[ind]);
                
                ans += total-max;
                
                total=0;
                max=Integer.MIN_VALUE;
            }
        }
        
        return ans;
    }
}