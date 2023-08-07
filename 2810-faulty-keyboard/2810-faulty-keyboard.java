class Solution {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder("");
        int start=0;
        int cnt=0, ind=0, n = s.length();
        char ch;
        
        while(ind<n){
            ch = s.charAt(ind++);
            
            if(ch=='i'){
                cnt++;
                continue;
            }
            
            if((cnt&1) != 0){
                start = 0;
            }
            else{
                start = sb.length();
            }
            
            sb.insert(start, ch);
        }
        
        return ((cnt&1) != 0) ? sb.reverse().toString() : sb.toString();
    }
}