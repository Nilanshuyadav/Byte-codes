class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        
        int[] sum_arr = new int[n];
        
        int sum = 0;

        if(k<0){
            k = -k;
            for(int ind=0; ind<k; ind++){
                sum += code[ind];
            }
        
            int ind = k;
            do{
                sum_arr[ind%n] = sum;
                
                sum += code[ind%n];
                sum -= code[ind-k];
                
                ind++;
                
            }while(ind%n != k);
        }

        else if(k>0){
            for(int ind=n-1; ind>n-k-1; ind--){
                sum += code[ind];
            }
            
            int ind = n-k-1;
            do{
                int temp = ind;
                if(ind<0)
                    temp = n+ind;

                sum_arr[temp] = sum;
                
                sum += code[temp];
                sum -= code[ind+k];
                ind--;
                
            }while(n+ind != n-k-1);
        }
        
        return sum_arr;
    }
}