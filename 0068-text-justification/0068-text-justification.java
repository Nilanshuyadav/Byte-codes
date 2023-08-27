class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        
        List<String> ans = new ArrayList<>();
        StringBuilder sb;
        
        int i=0, j=0, cnt, space, remaining, rem, temp, wrd_cnt;
        while(j<n){
            cnt = 0;
            space = 0;
            remaining = maxWidth;
            sb = new StringBuilder("");
            
            while(j<n && remaining >= words[j].length()+space){
                remaining -= words[j].length();
                space += 1;
                j++;
            }
            
            wrd_cnt = j-i;
            rem = wrd_cnt>1 ? remaining%(wrd_cnt-1) : remaining;
            
            // System.out.println(wrd_cnt + " " + rem + " "+remaining);
            
            for(int ind=i; ind<j; ind++){
                sb.append(words[ind]);
                
                temp = wrd_cnt>1 ? remaining/(wrd_cnt-1) : remaining;
                if(j==n){
                    temp = remaining;
                }
                
                while(ind!=j-1 && wrd_cnt>1 && temp-->0){
                    sb.append(" ");
                    
                    if(j==n){
                        remaining--;
                        break;
                    }
                }
                
                if(j!=n && rem > 0){
                    sb.append(" ");
                    rem--;
                }
            }
            
            while(j!=n && rem > 0){
                sb.append(" ");
                rem--;
            }
            
            if(j==n){
                while(remaining-->0){
                    sb.append(" ");
                }
            }
            
            ans.add(sb.toString());
            i = j;
        }
        
        return ans;
    }
}