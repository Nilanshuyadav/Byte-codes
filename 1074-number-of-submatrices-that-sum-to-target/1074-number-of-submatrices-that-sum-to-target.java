class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
     
        int n = matrix.length,m = matrix[0].length;
        
        for(int i=0;i<n;i++){
            for(int j = 1;j<m;j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }
        
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int curr,sum;
        
        for(int start = 0;start<m;start++){
            for(int end = start;end<m;end++){
                curr = 0; sum = 0;
                map.clear();
                
                for(int  i =0;i<n;i++){
                    curr = matrix[i][end];
                    
                    if(start>0) curr -= matrix[i][start-1];
                    
                    sum += curr;
                    
                    if(sum == target) ans++;
                    if(map.containsKey(sum-target)) ans += map.get(sum-target);
                    
                    map.put(sum,map.getOrDefault(sum,0)+1);
                }
                
            }
        }
        return ans;
    }
}