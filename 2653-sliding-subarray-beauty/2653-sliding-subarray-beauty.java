class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        List<Integer> al = new ArrayList<>();
        int n = nums.length;
        
        for(int ind=0; ind<k; ind++){
            al.add(nums[ind]);
        }
        
        Collections.sort(al, Collections.reverseOrder());
        
        int[] ans = new int[n-k+1];
        int i=0, ind=k, index;
        
        while(true){
            ans[i++] = al.get(k-x)<0 ? al.get(k-x) : 0;
            
            if(i>=(n-k+1)){
                break;
            }
            
            index = findPos(nums[ind-k], al);
            al.remove(index);
            
            index = findPos(nums[ind], al);
            al.add(index, nums[ind]);
            
            ind++;
        }
        
        return ans;
    }
    
    public int findPos(int target, List<Integer> al){
        int l=0, h=al.size()-1, m;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(al.get(m) == target){
                return m;
            }
            else if(al.get(m) < target){
                h = m-1;
            }
            else{
                l = m+1;
            }
        }
        
        return h+1;
    }
}