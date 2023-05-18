class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int[] temp_arr = new int[n];
        temp_arr[0] = 0;
        
        for(int ind=0; ind<n-1; ind++){
            if(derived[ind] == 1){
                temp_arr[ind+1] = (temp_arr[ind]+1)%2;
            }
            else{
                temp_arr[ind+1] = temp_arr[ind];
            }
        }
        
        if((derived[n-1]==1 && temp_arr[0]==temp_arr[n-1]) || (derived[n-1]==0 && temp_arr[0]!=temp_arr[n-1]))  
            return false;
        
        return true;
    }
}