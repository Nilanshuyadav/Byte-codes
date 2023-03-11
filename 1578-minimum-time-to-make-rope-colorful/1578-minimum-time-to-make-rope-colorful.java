class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        int ans=0;

        for(int ind=0; ind<n-1; ind++){
            if(colors.charAt(ind) == colors.charAt(ind+1)){
                int max = neededTime[ind], total = neededTime[ind];
                for(ind=ind; ind<n-1 && colors.charAt(ind)==colors.charAt(ind+1); ind++){
                    max = Math.max(max,neededTime[ind+1]);
                    total += neededTime[ind+1];
                }

                ans += (total-max);
            }
        }

        return ans;
    }
}