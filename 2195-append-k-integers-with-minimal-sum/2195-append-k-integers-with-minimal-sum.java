class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        
        long cnt=0, l, h, h_sum, l_sum;
        int temp_k = k, temp=1, ind=0, n=nums.length;
        
        while(ind<n && temp_k>0){
            
            while(ind!=n-1 && nums[ind] == nums[ind+1])
                ind++;
            
            if(nums[ind] != temp){
                cnt += temp++;
                
                temp_k--;
            }
            else{
                ind++;
                temp++;
            }
        }
        
        if(temp_k>0){
            h = temp+temp_k-1;
            l = temp-1;
            
            h_sum = (h*(h+1))/2;
            l_sum = (l*(l+1))/2;
            
            cnt += (h_sum - l_sum);
        }
        
        return cnt;
    }
}