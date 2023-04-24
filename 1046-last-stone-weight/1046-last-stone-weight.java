class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int ind : stones){
            q.add(ind);
        }
        
        int first, second;
        while(q.size() > 1){
            first = q.remove();
            second = q.remove();
            
            if(first != second)
                q.add(first-second);
        }
        
        return q.size()==1 ? q.remove() : 0;
    }
}