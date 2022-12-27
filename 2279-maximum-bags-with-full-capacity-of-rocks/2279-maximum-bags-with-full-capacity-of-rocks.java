class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]-a[1]) - (b[0]-b[1]));
        int n = rocks.length;
        
        for(int ind=0; ind<n; ind++){
            pq.add(new int[]{capacity[ind], rocks[ind]});
        }
        
        int cnt=0, sum=0;
        
        while(!pq.isEmpty()){
            int[] temp = pq.remove();
            
            sum += temp[0]-temp[1];
            
            if(sum>additionalRocks)
                break;
            
            cnt++;
        }
        
        return cnt;
    }
}