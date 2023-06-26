class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long total=0;
        
        if(n < 2*candidates){
            Arrays.sort(costs);
            
            for(int ind=0; ind<k; ind++){
                total += costs[ind];
            }
            
            return total;
        }
        
        int i=candidates-1, j=n-candidates, val, temp[], index;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);
        
        for(int in=0, jn=n-1; in<=i; in++, jn--){
            pq.add(new int[]{costs[in], in});
            pq.add(new int[]{costs[jn], jn});
        }
        
        while(i<j){
            if(k-->0){
                temp = pq.remove();
                
                val = temp[0];
                index = temp[1];
                
                total += val;
                
                if(j-i == 1){
                    break;
                }
                
                if(index <= i){
                    pq.add(new int[]{costs[++i], i});
                }
                else{
                    pq.add(new int[]{costs[--j], j});
                }
            }
            else{
                break;
            }
        }
        
        while(k-- > 0){
            total += pq.remove()[0];
        }
        
        return total;
    }
}