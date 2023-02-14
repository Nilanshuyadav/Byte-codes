class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder a_sb = new StringBuilder(a);
        StringBuilder b_sb = new StringBuilder(b);
        StringBuilder ans = new StringBuilder("");
        
        a_sb.reverse();
        b_sb.reverse();
        
        int a_len = a.length(), b_len = b.length();
        
        if(a_len<b_len){
            int temp = b_len-a_len;
            
            while(temp-->0)
                a_sb.append('0');
        }
        else if(b_len<a_len){
            int temp = a_len - b_len;
            
            while(temp-->0)
                b_sb.append('0');
        }
        
        char c = '0', toadd;
        
        for(int ind=0; ind<Math.max(a_len, b_len); ind++){
            char a_ch = a_sb.charAt(ind), b_ch = b_sb.charAt(ind);
            
            if(a_ch=='1' && b_ch=='1'){
                if(c=='1'){
                    toadd = '1';
                }
                else{
                    toadd = '0';
                }
                
                c = '1';
            }
            else if(a_ch=='0' && b_ch=='0'){
                if(c=='1'){
                    toadd = '1';
                }
                else{
                    toadd = '0';
                }
                
                c = '0';
            }
            else{
                if(c=='1'){
                    toadd = '0';
                    c = '1';
                }
                else{
                    toadd = '1';
                    c = '0';
                }
            }
            
            ans.append(toadd);
        }
        
        if(c=='1')
            ans.append(c);
        
        return ans.reverse().toString();
    }
}