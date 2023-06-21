class Solution {
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        int index=-1;
        
        for(int ind=0; ind<n; ind++){
            if(nums[ind] == k){
                index = ind;
            }
        }
        
        int cnt=0, sum = 0, ind = index;
        
        while(--ind>=0){
            if(nums[ind]<k){
                sum--;
            }
            else{
                sum++;
            }
            
            if(sum == 0 || sum == 1){
                cnt++;
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        ind=index;
        sum=0;
        
        while(++ind<n){
            if(nums[ind]<k){
                sum--;
            }
            else{
                sum++;
            }
            
            if(sum == 0 || sum == 1){
                cnt++;
            }
            
            cnt += map.getOrDefault(0-sum, 0);
            cnt += map.getOrDefault(0-sum+1, 0);
        }
        
        return cnt+1;
    }
}