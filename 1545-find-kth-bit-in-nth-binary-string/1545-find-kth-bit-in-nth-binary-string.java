class Solution {
    public char findKthBit(int n, int k) {
        String temp = dfs(n);
        return temp.charAt(k-1);
    }
    
    public String dfs(int n){
        if(n == 1)
            return "0";
        
        StringBuilder st = new StringBuilder(dfs(n-1));
    
        StringBuilder rev = new StringBuilder(st);
        
        return st+"1"+invert(rev.reverse());
    }
    
    public String invert(StringBuilder st){
        StringBuilder sb = new StringBuilder("");
        for(int ind=0; ind<st.length(); ind++)
            if(st.charAt(ind) == '0')
                sb.append('1');
            else
                sb.append('0');
        
        return sb.toString();
    }
}