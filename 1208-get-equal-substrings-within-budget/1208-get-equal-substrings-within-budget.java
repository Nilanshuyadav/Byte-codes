class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int pre = 0, diff=0, max=0;
        
        for(int curr=0; curr<n; curr++){
            diff = Math.abs(s.charAt(curr) - t.charAt(curr));
            
            if(diff <= maxCost){
                maxCost -= diff;
            }
            else{
                max = Math.max(max, curr-pre);
                maxCost += Math.abs(s.charAt(pre)-t.charAt(pre));
                pre++;
                
                curr--;
            }
        }
        
        return Math.max(max, n-pre);
    }
}