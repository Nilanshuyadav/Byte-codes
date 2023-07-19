class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        
        Arrays.sort(nums);
        
        int[] l_arr = new int[n], u_arr = new int[n];
        
        for(int ind=0; ind<n; ind++){
            l_arr[ind] = nums[ind]-k;
            u_arr[ind] = nums[ind]+k;
        }

        int a=l_arr[n-1], b=u_arr[0];
        
        int val1=0, val2=0, a_pos = findPos(a, u_arr), b_pos = findPos(b, l_arr);
        
        for(int ind=0; ind<n; ind++){
            a_pos = findPos(l_arr[ind], u_arr);
            
            val1 = Math.max(val1, ind+1-a_pos);
            
            
            b_pos = findPos(u_arr[ind], l_arr);

            if(b_pos<n && l_arr[b_pos] == b){
                val2 = Math.max(val2, b_pos+1-ind);
            }
            else{
                val2 = Math.max(val2, b_pos-ind);
            }
        }
        
        return Math.max(val1, val2);
    }
    
    public int findPos(int target, int[] arr){
        int n=arr.length, l=0, h=n-1, m;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(arr[m] <= target){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        
        return h+1;
    }
}