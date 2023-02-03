class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        
        int n = s.length();
        String[] arr = new String[numRows];
        StringBuilder sb = new StringBuilder("");
        
        int jump = 2*(numRows-1);
        
        for(int ind=0; ind<n; ind += jump){
            sb.append(s.charAt(ind));
        }
        arr[0] = sb.toString();
        
        sb = new StringBuilder("");
        for(int ind=numRows-1; ind<n; ind+= jump)
            sb.append(s.charAt(ind));
        
        arr[numRows-1] = sb.toString();
        
        for(int ind=1; ind<=numRows-2; ind++){
            sb = new StringBuilder("");
            
            boolean bool = true;
            
            for(int inx=ind; inx<n; inx += jump){
                if(bool){
                    jump = 2*(numRows-ind-1);
                    bool = false;
                }    
                else{
                    jump = 2*(ind);
                    bool = true;
                }
                
                sb.append(s.charAt(inx));
            }
            
            arr[ind] = sb.toString();
        }
        
        StringBuilder ans = new StringBuilder("");
        
        for(String st : arr)
            ans.append(st);
        
        return ans.toString();
    }
}