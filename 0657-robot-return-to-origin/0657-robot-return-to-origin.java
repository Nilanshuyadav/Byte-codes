class Solution {
    public boolean judgeCircle(String moves) {
        int r=0,l=0,u=0,d=0;
        
        for(int ind=0; ind<moves.length(); ind++){
            char ch = moves.charAt(ind);
            
            if(ch=='R')
                r++;
            else if(ch=='L')
                l++;
            else if(ch=='U')
                u++;
            else
                d++;
        }
        
        return r==l && u==d;
    }
}