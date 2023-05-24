class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Pair[] arr = new Pair[n];
        
        for(int ind=0; ind<n; ind++){
            arr[ind] = new Pair(nums1[ind], nums2[ind]);
        }
        
        Arrays.sort(arr, (a,b) -> b.nums2 - a.nums2);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        long sum = 0, ans = 0;
        int size = 0;
        
        for(Pair ind : arr){
            if(size == k){
                sum -= pq.remove();
                size--;
            }    
            
            sum += ind.nums1;
            pq.add(ind.nums1);
            size++;
            
            if(size == k){
                ans = Math.max(ans, sum * ind.nums2);
            }
        }
        
        return ans;
    }
}

class Pair{
    int nums1, nums2;
    
    public Pair(int nums1, int nums2){
        this.nums1 = nums1;
        this.nums2 = nums2;
    }
}