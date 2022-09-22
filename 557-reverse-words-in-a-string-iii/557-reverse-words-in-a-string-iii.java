class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int pre = 0;
        
        for(int ind=0; ind<n; ind++){
            if(arr[ind]==' '){
                int low = pre, high = ind-1;
                while(low<high){
                    char temp = arr[low];
                    arr[low] = arr[high];
                    arr[high] = temp;
                    
                    low++;
                    high--;
                }
                pre = ind+1;
            }    
        }
        
        int low = pre, high = n-1;
        while(low<high){
            char temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            low++;
            high--;
        }
        
        return new String(arr);
    }
}