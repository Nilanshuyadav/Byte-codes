class Solution {
    public String multiply(String num1, String num2) {
        
        int n = num1.length();
        int m = num2.length();
        
        int[] arr = new int[m+n];
        
        for(int i=m-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                
                int val1 = num2.charAt(i)-'0';
                int val2 = num1.charAt(j)-'0';
                
                arr[i+j+1] += val1*val2;
                arr[i+j] += arr[i+j+1]/10;
                arr[i+j+1] %= 10;
            }
        }
        
        StringBuilder st = new StringBuilder("");
        
        int flg = 0;
        
        for(int i=0;i<m+n;i++){
            if(flg ==1 || arr[i]!=0){
                st.append(arr[i]);
                flg = 1;
            }
        }
        
        return st.toString()==""?"0":st.toString();
    }
}