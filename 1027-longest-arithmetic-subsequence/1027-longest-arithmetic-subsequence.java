class Solution {
//     public int longestArithSeqLength(int[] nums) {
//         int n = nums.length;
        
//         Map<Integer, List<Integer>> map = new HashMap<>();
        
//         for(int ind=0; ind<n; ind++){
//             map.putIfAbsent(nums[ind], new ArrayList<>());
            
//             map.get(nums[ind]).add(ind);
//         }
        
//         System.out.println(map);
//         int curr, curr_ind, cnt, diff, ans=0;
        
//         for(int i=0; i<n-1; i++){
//             for(int j=i+1; j<n; j++){
//                 diff = nums[j] - nums[i];
                
//                 curr = nums[j];
//                 curr_ind = j;
//                 cnt=2;
                
                
//                 if(diff == 0){
//                     for(int ind : nums){
//                         if(ind == nums[i]){
//                             cnt++;
//                         }
//                     }
                    
//                     cnt -= 2;
//                 }
//                 else{
//                     while(map.containsKey(curr+diff)){
//                         int pos = findPos(map.get(curr+diff), curr_ind);
//                         if(pos == map.get(curr+diff).size()){
//                             break;
//                         }
                        
//                         cnt++;
//                         curr = curr+diff;
//                         curr_ind = pos;
                        
//                         if(i==16 && j==32){
//                             System.out.println(curr+" "+ curr_ind);
//                         }
//                     }    
//                 }
                
//                 ans = Math.max(ans, cnt);
                
//             }
//         }
        
//         return ans;
//     }
    
//     public int findPos(List<Integer> al, int target){
//         int l=0, h=al.size()-1, m;
        
//         while(l<=h){
//             m = l + (h-l)/2;
            
//             if(target < al.get(m)){
//                 h = m-1;
//             }
//             else{
//                 l = m+1;
//             }
//         }
        
//         return h+1;
//     }
    
     public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if (n <= 2)
            return n;

        int longest = 2;
        Map<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                longest = Math.max(longest, dp[i].get(diff));
            }
        }

        return longest;
    }
}