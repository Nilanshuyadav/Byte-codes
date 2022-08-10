class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Queue<Integer> q = new LinkedList<>();        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<n;i++){
            if(manager[i] == -1) {continue;}
            adj.get(manager[i]).add(i);
        }
        
//         int val = -1,cnt = 0,max = Integer.MIN_VALUE;
        
//         while(!q.isEmpty()){
//             int size = q.size();
//             max = Integer.MIN_VALUE;
            
//             while(size-->0){
//                 int temp = q.remove();
//                 if(informTime[temp] > max){
//                     max = informTime[temp];
//                     val = temp;
//                 }
//                 for(int i : adj.get(val))
//                     q.add(i);
//             }
//             cnt += max;
//         }
        
//         return cnt;
        
        
        return function(headID,adj,informTime);
        
    }
    
    
    public int function(int ind,List<List<Integer>> adj, int[] it){
        
        int max = 0;        
        for(int i : adj.get(ind))
            max = Math.max(max, it[ind] + function(i,adj,it));
        
        return max;
    }
}