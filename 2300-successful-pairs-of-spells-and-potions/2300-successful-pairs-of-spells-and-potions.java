class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m=potions.length;
        
        int[] pairs = new int[n];
        
        Arrays.sort(potions);
        
        long q;
        
        for(int ind=0; ind<n; ind++){
            q = (success+spells[ind]-1)/spells[ind];
            
            pairs[ind] = (m-findPos(q, potions));
        }
        
        return pairs;
    }
    
    public int findPos(long target, int[] potions){
        int l=0, h=potions.length-1, m, ans=Integer.MAX_VALUE;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(potions[m] == target)   {ans=Math.min(m, ans); h=m-1;}
            else if(potions[m] < target) l=m+1;
            else h=m-1;
        }
        
        return ans==Integer.MAX_VALUE? l : ans;
    }
}