class Solution {
    String[] place = {"0","1","0Hundred", "0Thousand", "1Thousand", "2Thousand", "0Million", "1Million", "2Million", "0Billion"},
    digit = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"},
    forOne = {"Ten","Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"},
    tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        return helper(String.valueOf(num));
    }
    
    public String helper(String st){
        if(st.charAt(0)=='0') return "Zero";
        
        int n = st.length();
        StringBuilder sb = new StringBuilder("");
        int cnt = 1;
        
        char ch;
        String pl;
        
        for(int i=0; i<n; i+=cnt){
            cnt=1;
            ch = st.charAt(i);
            
            if(ch=='0') continue;
            
            pl = place[n-i-1];
            
            if(pl.length()==1){
                if(pl.charAt(0)=='0'){
                    sb.append(" "+digit[ch-'0']);
                }
                else{
                    if(ch=='1'){
                        sb.append(" "+forOne[st.charAt(i+1)-'0']);
                        cnt = 2;
                    }
                    else{
                        sb.append(" "+tens[ch-'0']);
                        
                        if(st.charAt(i+1)!='0'){
                            sb.append(" "+digit[st.charAt(i+1)-'0']);    
                        }
                        
                        cnt=2;
                    }
                }
            }
            else if(pl.charAt(0)=='0'){
                sb.append(" "+digit[ch-'0']);
            }
            else if(pl.charAt(0)=='1'){
                sb.append(" "+helper(st.substring(i, i+2)));
                cnt = 2;
            }
            else if(pl.charAt(0)=='2'){
                sb.append(" "+helper(st.substring(i, i+3)));
                cnt = 3;
            }
            
            if(pl.length()>1)
                sb.append(" "+pl.substring(1));
        }
        
        return sb.substring(1);
    }
}