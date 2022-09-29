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
        ans.add(arr[min_ind]+x);
        
        int low = min_ind-1, high = min_ind+1;
        
        while(low>=0 && high<n && --k>0){
            if(Math.abs(arr[high])<Math.abs(arr[low])) ans.add(arr[high++]+x);
            else ans.add(arr[low--] + x);
        }
        
        while(low>=0 && --k>0) ans.add(arr[low--]+x);
        while(high<n && --k>0) ans.add(arr[high++]+x);
        
        Collections.sort(ans);
        
        return ans;
    }
}