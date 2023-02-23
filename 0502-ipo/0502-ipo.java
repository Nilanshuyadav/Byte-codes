class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        PriorityQueue<Integer> selective = new PriorityQueue<>(Collections.reverseOrder());
        
        int n = profits.length, sum=0;
        
        for(int ind=0; ind<n; ind++){
            sum += profits[ind];
            pq.add(new int[]{profits[ind], capital[ind]});
        }
        
        if(k>=n) k=n;
        
        int current = w;
        
        for(int i=0; i<k; i++){
            while(pq.size()>0 && pq.peek()[1]<=current){
                selective.add(pq.remove()[0]);
            }
            
            if(selective.size()>0)
                current += selective.remove();
        }
        
        return current;
    }
}