class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length, dif;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n-1; i++){
            dif = heights[i+1]-heights[i];

            if(dif>0){
                pq.add(dif);

                if(pq.size()>ladders){
                    bricks -= pq.remove();

                    if(bricks<0) return i;
                }
            }
        }

        return n-1;
    }
}