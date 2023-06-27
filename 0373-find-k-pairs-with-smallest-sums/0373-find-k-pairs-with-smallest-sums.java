class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
       PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b) -> (b.get(0)+b.get(1)) - (a.get(0)+a.get(1)));

        for(int r=0; r<Math.min(k, nums1.length); r++){
            for(int c=0; c<Math.min(k, nums2.length); c++){
                if(pq.size()<k)
                    pq.add(Arrays.asList(nums1[r], nums2[c]));
                else{
                    if(nums1[r]+nums2[c]<pq.peek().get(0)+pq.peek().get(1)){
                        pq.remove();
                        pq.add(Arrays.asList(nums1[r], nums2[c]));
                    }
                    else
                        break;
                }
            }
        }

       return new ArrayList<>(pq);

    }
}