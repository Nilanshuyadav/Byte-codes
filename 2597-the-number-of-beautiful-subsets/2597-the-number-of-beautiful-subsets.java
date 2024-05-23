class Solution {
    int cnt;
    public int beautifulSubsets(int[] nums, int k) {
        int n = nums.length;
        cnt=-1;
        
        helper(n-1, nums, k, new ArrayList<>(), new HashMap<>());
        return cnt;
    }
    
    public void helper(int ind, int[] nums, int k, List<Integer> al, Map<Integer, Integer> map){
        if(ind == -1){
            cnt += 1;
            return; 
        }
        
        if(!map.containsKey(nums[ind]+k) && !map.containsKey(nums[ind]-k)){
            al.add(nums[ind]);
            map.put(nums[ind], map.getOrDefault(nums[ind], 0) + 1);
            
            helper(ind-1, nums, k, al, map);
            
            al.remove(al.size()-1);
            map.put(nums[ind], map.getOrDefault(nums[ind], 1) - 1);

            if(map.get(nums[ind])<=0) map.remove(nums[ind]);
        }
            
        helper(ind-1, nums, k, al, map);
        
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