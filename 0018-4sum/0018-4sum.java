class Solution {
    public List<List<Integer>> fourSum(int[] nums, long target) {
        int n = nums.length;
        int c, d;
        long toFind, sum;
        
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int a=0; a<n-3; a++){
            for(int b=a+1; b<n-2; b++){
                toFind = target - nums[a] - nums[b];
                
                c = b+1;
                d = n-1;
                while(c < d){
                    sum = nums[c] + nums[d];
                    
                    if(sum == toFind){
                        ans.add(new ArrayList<>(Arrays.asList(nums[a], nums[b], nums[c], nums[d])));
                        
                        while(c<d && nums[c]==nums[c+1]) c++;
                        while(c<d && nums[d]==nums[d-1]) d--;
                        
                        c++;
                        d--;
                    }
                    else if(sum > toFind){
                        d--;
                    }
                    else{
                        c++;
                    }
                }
                
                while(b<n-2 && nums[b]==nums[b+1]) b++;
            }
            
            while(a<n-3 && nums[a]==nums[a+1]) a++;
        }
        
        return ans;
    }
}