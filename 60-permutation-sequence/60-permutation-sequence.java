class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<=n;i++){
            sb.append(i);
        }
        
        while(k-->1){
            sb = nextPermutation(sb,n);
        }
        
        return sb.toString();
    }
    
    public StringBuilder nextPermutation(StringBuilder s, int n){
        int i = n-1;
        if(n==1) return s;
        
        while(i > 0 && s.charAt(i)<s.charAt(i-1)) i--;
        
        int ind1 = --i;
        
        i = n-1;
        while(ind1>=0 && s.charAt(i)<s.charAt(ind1))i--;
        
        char ch;
        
        if(ind1 >=0 ){
            ch = s.charAt(ind1);
            s.setCharAt(ind1,s.charAt(i));
            s.setCharAt(i,ch);
        }    
        
        ind1++;
        while(ind1<n-1){
            ch = s.charAt(ind1);
            s.setCharAt(ind1,s.charAt(n-1));
            s.setCharAt(n-1,ch);
            
            ind1++;
            n--;
        }
        
        return s;
        
        
    }
}