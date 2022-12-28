class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int ind : piles)
            pq.add(ind);
        
        while(k-->0){
            int temp = pq.remove();
            
            pq.add(temp - (temp/2));
        }
        
        int sum = 0;
        while(!pq.isEmpty())
            sum += pq.remove();
        
        return sum;
    }
}