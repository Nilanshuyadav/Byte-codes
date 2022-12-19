class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        
        List<Integer> al = new ArrayList<>();
        
        int[] pre = new int[n];
        int prev = 0;
        
        for(int ind=0; ind<n; ind++){
            pre[ind] = prev^arr[ind];
            prev = pre[ind];
        }
        
        for(int ind[] : queries){
            al.add(pre[ind[1]]^pre[ind[0]]^arr[ind[0]]);    
        }
        
        int size = al.size(), k=0;
        int[] res = new int[size];
        
        for(int ind : al)
            res[k++] = ind;
        
        return res;
    }
}