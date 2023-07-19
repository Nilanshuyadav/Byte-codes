class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Boolean[] arr = new Boolean[n+1];
        
        for(int i=2; i<=n; i++){
            if(arr[i]!=null && !arr[i]){
                continue;
            }
            
            arr[i] = true;
            makeFalse(arr, i);
        }
        
        for(int i=2; i<=n/2; i++){
            if(arr[i] && arr[n-i]){
                ans.add(new ArrayList<>(Arrays.asList(i, n-i)));
            }
        }
        
        return ans;
    }
    
    
    public void makeFalse(Boolean[] arr, int i){
        int n = arr.length;
        int temp = i+i;
        while(temp<n){
            arr[temp] = false;
            temp += i;
        }
    }
}