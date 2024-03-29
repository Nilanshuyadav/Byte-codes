class Solution {
    public long[] getDistances(int[] arr) {
        Map<Integer, long[]> map = new HashMap<>();
        
        int n = arr.length;
        long temp[], val, pre_ind, total_occ, sum, ans[] = new long[n];
        
        for(int ind=0; ind<n; ind++){
            if(map.containsKey(arr[ind])){
                temp = map.get(arr[ind]);
                
                pre_ind = temp[0];
                total_occ = temp[1];
                sum = temp[2];
                
                val = sum + ((total_occ)*(ind-pre_ind));
                
                temp[0] = ind;
                temp[1] = temp[1]+1;
                temp[2] = val;
                
                map.put(arr[ind], temp);
            }   
            else{
                map.put(arr[ind], new long[]{ind, 1, 0});
                
                val = 0;
            }
            
            ans[ind] = val;
        }
        
        map.clear();
        
        for(int ind=n-1; 0<=ind; ind--){
            if(map.containsKey(arr[ind])){
                temp = map.get(arr[ind]);
                
                pre_ind = temp[0];
                total_occ = temp[1];
                sum = temp[2];
                
                val = sum + ((total_occ)*(pre_ind-ind));
                
                temp[0] = ind;
                temp[1] = temp[1]+1;
                temp[2] = val;
                
                map.put(arr[ind], temp);
            }
            else{
                map.put(arr[ind], new long[]{ind, 1, 0});
                
                val = 0;
            }
            
            ans[ind] += val;
        }
        
        return ans;
    }
}