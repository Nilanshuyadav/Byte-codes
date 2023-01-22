class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Pair[] arr = new Pair[n];
        
        for(int ind=0; ind<n; ind++){
            arr[ind] = new Pair(nums1[ind], nums2[ind]);
        }
        
        Arrays.sort(arr, (a, b) -> b.num2-a.num2);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        long sum = 0, ans=0;
        int size=0;
        
        for(Pair ind : arr){
            if(size==k){
                sum -= pq.remove();
                size--;
            }
            
            sum += ind.num1;
            pq.add(ind.num1);
            size++;
            
            if(size==k){
                ans = Math.max(ans, sum*ind.num2);
            }
        }
        
        return ans;
    }
}

class Pair{
    int num1, num2;
    
    public Pair(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }
}