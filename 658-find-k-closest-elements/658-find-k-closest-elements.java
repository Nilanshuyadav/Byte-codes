class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int min_ind=0, min=Integer.MAX_VALUE, n = arr.length;
        
        for(int ind=0; ind<n; ind++){
            int temp = arr[ind]-x;
            
            if(Math.abs(temp)<min){
                min = Math.abs(temp);
                min_ind = ind;
            }
            
            arr[ind] = temp;
        }    
        
        List<Integer> ans = new ArrayList<>();
        
        int low = min_ind-1, high = min_ind+1;
        
        while(low>=0 && high<n && --k>0)
            if(Math.abs(arr[high])<Math.abs(arr[low])) high++;
            else low--;
        
        while(low>=0 && --k>0) low--;
        while(high<n && --k>0) high++;
        
        for(int ind=low+1; ind<high; ind++)
            ans.add(arr[ind]+x);
        
        return ans;
    }
}