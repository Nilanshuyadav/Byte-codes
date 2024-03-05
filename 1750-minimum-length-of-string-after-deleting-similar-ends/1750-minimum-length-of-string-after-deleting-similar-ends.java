class Solution {
    public int minimumLength(String s) {
        int l=0, h=s.length()-1;
        
        while(l<h && s.charAt(l)==s.charAt(h)){
            while(l<h && s.charAt(l)==s.charAt(l+1)) l++;
            while(l<h && s.charAt(h)==s.charAt(h-1)) h--;
            
            l++;
            h--;
        }
        
        return Math.max(0, h-l+1);
    }
}