class Solution {
    public boolean repeatedSubstringPattern(String s) {
        List<Integer> al = new ArrayList<>();
        int n = s.length();
        
        for(int ind=1; ind<n; ind++){
            if(s.charAt(ind) == s.charAt(0))
                al.add(ind);
        }
        
        for(int ind : al){
            if(check(0, ind, ind-0, s, n))   return true;
        }
        
        return false;
    }
    
    public boolean check(int s, int e, int diff, String string, int n){
        String st = string.substring(s,e);
        
        while(e<=n){
            
            if(!string.substring(s,e).equals(st))    return false;
            
            s = e;
            e += diff;
        }
        
        return s==n?true:false;
    }
}