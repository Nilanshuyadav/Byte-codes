class Solution {
    public int findKthPositive(int[] arr, int k) {
        int curr = 0, ind=0, n = arr.length;
        
        while(k>0){
            curr++;
            
            if(ind<n && arr[ind]==curr){
                ind++;
                continue;
            }
            else{
                k--;
            }
        }
        
        return curr;
    }
}