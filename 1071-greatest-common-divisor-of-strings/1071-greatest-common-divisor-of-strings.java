class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2=str2.length();
        
        if(len2>len1){
            String temp = str2;
            str2 = str1;
            str1 = temp;
        }
        
        int n = str2.length();
        
        for(int ind=n; ind>0; ind--){
            if(dfs(str2.substring(0,ind), str1) && dfs(str2.substring(0, ind), str2))
                return str2.substring(0, ind);
        }
        
        return "";
    }
    
    public boolean dfs(String s, String str1){
        int n = s.length();
        int m = str1.length();
        
        if(m%n!=0)
            return false;
        
        for(int ind=0; ind<m; ind += n)
            if(!s.equals(str1.substring(ind, ind+n)))
                return false;
        
        return true;
    }
}