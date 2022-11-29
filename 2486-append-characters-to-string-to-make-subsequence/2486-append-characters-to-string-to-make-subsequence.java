class Solution {
    public int appendCharacters(String s, String t) {
        int s_st=0, t_st=0, s_n=s.length(), t_n=t.length();
        
        while(s_st<s_n && t_st<t_n){
            char ch = t.charAt(t_st);
            while(s_st<s_n && s.charAt(s_st)!=ch)
                s_st++;
            
            if(s_st>=s_n)
                return t_n - t_st;
            
            s_st++;
            t_st++;
        }
        
        if(t_st>=t_n)        
            return 0;
        
        return t_n-t_st;
    }
}