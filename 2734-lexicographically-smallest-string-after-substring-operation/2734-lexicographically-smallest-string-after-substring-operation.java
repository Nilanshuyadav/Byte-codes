class Solution {
    public String smallestString(String s) {
        
        int n=s.length(), a_pos=n, start=0;
        
        StringBuilder ans = new StringBuilder("");        
        
        for(int ind=0; ind<n; ind++){
            if(s.charAt(ind) == 'a'){
                a_pos = ind;
                break;
            }
        }
        
        if(a_pos == 0){
            int inx=0;
            
            while(inx<n-1){
                if(s.charAt(inx) != 'a'){
                    break;
                }
                inx++;
            }
            
            start = inx;
            a_pos = n;
        }

        char ch;
        
        for(int ind=0; ind<start; ind++){
            ans.append(s.charAt(ind));
        }
        
        for(int ind=start; ind<a_pos; ind++){
            ch = s.charAt(ind);
            
            if(ch == 'a'){
                if(ind!=start){
                    a_pos = ind;
                    break;
                }
                
                ans.append('z');
            }
            else{
                ans.append((char)(ch-1));
            }
        }
        
        for(int ind=a_pos; ind<n; ind++){
            ans.append(s.charAt(ind));
        }
        
        return ans.toString();
    }
}