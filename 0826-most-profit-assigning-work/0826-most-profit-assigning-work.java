class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        
        for(int i=0; i<n; i++){
            pq.add(new int[]{difficulty[i], profit[i]});
        }
        
        int sum = 0;
        
        Arrays.sort(worker);
        
        for(int i=worker.length-1; !pq.isEmpty() && i>=0; i--){
            
            if(worker[i] >= pq.peek()[0]){
                sum += pq.peek()[1];
            }    
            else{
                pq.remove();
                i++;
            }
        }
        
        return sum;
    }
}