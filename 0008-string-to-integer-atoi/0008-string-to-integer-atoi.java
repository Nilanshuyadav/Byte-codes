class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder("");
        
        char ch;
        boolean first = true;
        
        for(int ind=0; ind<n; ind++){
            ch = s.charAt(ind);
            
            if(ch==' ' && sb.length()==0) continue;
            
            if(('0'<=ch && ch<='9') || ((ch=='+' || ch=='-') && first && sb.length()==0)){
                if(ch=='+' || ch=='-'){
                    first = false;
                }
                sb.append(ch);
            }
            else{
                break;
            }
        }
        
        if(sb.length()==0){
            return 0;
        }
        
        int inx;
        
        if('0'<=sb.charAt(0) && sb.charAt(0)<='9'){
            inx=0;
        }
        else{
            inx=1;
        }
        
        while(inx<sb.length() && sb.charAt(inx)=='0'){
            sb.deleteCharAt(inx);
        }
        
        int sign=1;
        
        if(inx==1){
            sign = sb.charAt(0)=='-' ? -1 : 1;
            sb.deleteCharAt(0);
        }
        
        if(sb.length()==0){
            return 0;
        }
        
        int size = sb.length();
        
        if(size>10){
            return sign==1?Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        long num = sign*Long.valueOf(sb.toString());
        
        if(num>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        else if(num<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        
        return (int)num;
    }
}