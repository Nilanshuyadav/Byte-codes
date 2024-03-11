class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String arr[] = s.split(" ");
        
        int n = arr.length;
        
        int l=0, h=n-1;
        String str;
        
        while(l<h){            
            str = arr[l];
            arr[l] = arr[h];
            arr[h] = str;
            
            l++;
            h--;
        }
        
        StringBuilder sb = new StringBuilder("");
        
        for(String st : arr){
            if(!st.equals("")){
                sb.append(" ");
                sb.append(st);
            }
        }
        
        return sb.substring(1);
    }
}