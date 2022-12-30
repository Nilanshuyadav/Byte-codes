class Solution {
    public int myAtoi(String s) {
        StringBuilder sb = new StringBuilder("");
        
        int n = s.length();
        boolean got_symbol=false, first=true, negative=false, digit_start=false;
        
        for(int ind=0; ind<n; ind++){
            char ch = s.charAt(ind);
            
            if(ch == ' ' && !got_symbol && first && !digit_start)
                continue;
            
            if(!got_symbol && first && (ch=='-' || ch=='+') && !digit_start){
                got_symbol = true;
                
                if(ch == '-')
                    negative = true;
            }
            else if(('1'<=ch && ch<='9') || (ch=='0' && !first)){
                sb.append(ch);
                first = false;
            }
            
            else if(ch!='0') break;
            else digit_start=true;
        }
        
        String st = sb.toString();
        System.out.println(st);
        
        if(st.equals(""))
            return 0;
        
        long ans=0;
        if(negative){
            if(st.length()>10)
                return Integer.MIN_VALUE;
            else
                ans = Math.max(Integer.MIN_VALUE, 0-Long.valueOf(st,10));
        }
        else {
            if(st.length()>10)
                return Integer.MAX_VALUE;
            else
                ans = Math.min(Integer.MAX_VALUE, Long.valueOf(st,10));
        }
        
        return (int)ans;
    }
}