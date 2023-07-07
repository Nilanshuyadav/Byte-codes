class Solution {
    public int maxConsecutiveAnswers(String st, int k) {
        char ch;
        
        int[] arr = new int[2];
        int n = st.length(), i=0, ans=0;
        
        for(int ind=0; ind<n; ind++){
            ch = st.charAt(ind);
            
            if(ch=='F'){
                arr[1]++;
                
                while(arr[1]>k){
                    ch = st.charAt(i);

                    if(ch=='F'){
                        arr[1]--;
                    }

                    i++;
                }
            }
            
            ans = Math.max(ans, ind-i+1);
        }
        
        i=0;
        for(int ind=0; ind<n; ind++){
            ch = st.charAt(ind);
            
            if(ch=='T'){
                arr[0]++;
                
                while(arr[0]>k){
                    ch = st.charAt(i);

                    if(ch=='T'){
                        arr[0]--;
                    }

                    i++;
                }
            }
            
            ans = Math.max(ans, ind-i+1);
        }
        
        return ans;
    }
}