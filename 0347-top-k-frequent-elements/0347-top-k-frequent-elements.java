class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int ind : nums){
            map.put(ind, map.getOrDefault(ind, 0) + 1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        
        int[] ans = new int[k];
        int i=0;
        
        while(i<k){
            ans[i++] = pq.remove()[0];
        }
        
        return ans;
    }
}