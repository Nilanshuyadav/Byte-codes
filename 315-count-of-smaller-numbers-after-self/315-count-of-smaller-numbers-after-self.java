class Solution {
    Integer[] ans;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        
        Pair[] num = new Pair[n];
        
        for(int i=0;i<n;i++)
            num[i] = new Pair(nums[i],i);
        
        ans = new Integer[n];
        
        Arrays.fill(ans,0);
        
        merge_break(0,n-1,num);
        
        return new ArrayList<>(Arrays.asList(ans));
    }
    
    public void merge_break(int low, int high, Pair[] num){
        if(low<high){
            int mid = (low+high)/2;
            
            merge_break(low,mid,num);
            merge_break(mid+1,high,num);
            
            merge(low,mid,high,num);
        }
    }
    
    public void merge(int low, int mid ,int high, Pair[] num){
        int n = (mid-low+1)+(high-mid);
        
        Pair[] temp = new Pair[n];
        
        int temp_curr = 0,f_curr = low, s_curr = mid+1;
        
        while(f_curr<=mid && s_curr<=high){
            if(num[f_curr].val>num[s_curr].val){
                ans[num[f_curr].ind] += high-s_curr+1;
                temp[temp_curr++] = num[f_curr++];
            }
            else{
                temp[temp_curr++] = num[s_curr++];
            }
        }
        
        while(f_curr<=mid)
            temp[temp_curr++] = num[f_curr++];
        
        while(s_curr<=high)
            temp[temp_curr++] = num[s_curr++];
        
        for(int curr = low;curr<=high;curr++)
            num[curr] = temp[curr-low];
    }
    
}

class Pair{
    int val;
    int ind;
    public Pair(int val, int ind){
        this.val = val;
        this.ind = ind;
    }
}