class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length, i=0, j, k, toFind, sum;
        List<List<Integer>> ans = new ArrayList<>();
        
        while(i<n-2){
            toFind = -nums[i];
            
            j = i + 1;
            k = n-1;
            while(j<k){
                sum = nums[j] + nums[k];
                
                if(sum == toFind){
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    while(j<k && nums[j]==nums[j+1]) j++;
                    while(j<k && nums[k]==nums[k-1]) k--;
                    
                    j++;
                    k--;
                }
                else if(sum > toFind){
                    k--;
                }
                else{
                    j++;
                }
            }
            
            while(i<n-2 && nums[i]==nums[i+1]) i++;
            i++;
        }
        
        return ans;
    }
}