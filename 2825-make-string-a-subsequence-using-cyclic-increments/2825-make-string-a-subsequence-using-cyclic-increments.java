class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        return solve(0, 0, str1, str2, str1.length(), str2.length());
    }
    
    public boolean solve(int ind, int ind2, String s1, String s2, int l1, int l2){
        if(ind2 == l2){
            return true;
        }
        
        boolean bool = false;
        
        for(int i=ind; i<l1; i++){
            if(s1.charAt(i)==s2.charAt(ind2) || s1.charAt(i)==pre(s2.charAt(ind2))){
                bool |= solve(i+1, ind2+1, s1, s2, l1, l2);
                
                break;
            }
        }
        
        return bool;
    }
    
    public char pre(char ch){
        if(ch=='a') return 'z';
        return (char)(ch-1);
    }
}