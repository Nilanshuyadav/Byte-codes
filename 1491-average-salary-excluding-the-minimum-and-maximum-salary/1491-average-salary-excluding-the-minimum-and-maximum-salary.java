class Solution {
    public double average(int[] salary) {
        double ans=0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        for(int ind : salary){
            ans += ind;
            
            min = Math.min(min, ind);
            max = Math.max(max, ind);
        }
        
        ans -= min;
        ans -= max;
        
        return ans/(salary.length-2);
    }
}