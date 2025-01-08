class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length, i=0, dif;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(i=0; i<n-1; i++){
            if(heights[i]<heights[i+1]){
                dif = heights[i+1]-heights[i];

                if(dif <= bricks){
                    bricks -= dif;
                    pq.add(dif);
                }
                else if(ladders>0){
                    ladders--;
                    if(pq.size()>0 && dif<pq.peek()){
                        bricks += pq.remove();
                        i--;
                    }
                }
                else{
                    break;
                }
            }
        }

        return i;
    }
}