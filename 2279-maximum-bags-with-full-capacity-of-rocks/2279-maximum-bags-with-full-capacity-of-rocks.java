class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        List<Integer> al = new ArrayList<>();
        int n = rocks.length;
        
        for(int ind=0; ind<n; ind++)
            al.add(capacity[ind]-rocks[ind]);
        
        Collections.sort(al);
        
        int sum=0, cnt=0;
        
        for(int ind : al){
            sum += ind;
            
            if(additionalRocks<sum)
                break;
            
            cnt++;
        }
        
        return cnt;
    }
}