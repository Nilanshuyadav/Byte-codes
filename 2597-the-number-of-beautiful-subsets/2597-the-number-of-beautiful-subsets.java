class Solution {
    int cnt;
    public int beautifulSubsets(int[] nums, int k) {
        int n = nums.length;
        cnt=0;
        
        helper(n-1, nums, k, new ArrayList<>());
        return cnt-1;
    }
    
    public void helper(int ind, int[] nums, int k, List<Integer> al){
        if(ind == -1){
            cnt += beautiful(al, k);
            return; 
        }
        
        al.add(nums[ind]);
        helper(ind-1, nums, k, al);
        
        al.remove(al.size()-1);
        helper(ind-1, nums, k, al);
    }
    
    public int beautiful(List<Integer> al, int k){
        int diff;
        Set<Integer> set = new HashSet<>();

        for(int i : al){
            if(set.contains(k+i) || set.contains(i-k)) return 0;
            set.add(i);
        }
        
        return 1;
    }
}


// [2,4,6]
// 2
// [1]
// 1
// [4,2,5,9,10,3]
// 1
// [10,4,5,7,2,1]
// 3