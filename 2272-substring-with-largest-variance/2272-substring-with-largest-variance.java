class Solution {
    public int largestVariance(String s) {
        int n = s.length(), ans=0;
        int cnt1=0, cnt2=0;
        char ch;
        
        for(char ch1='a'; ch1<='z'; ch1++){
            for(char ch2='a'; ch2<='z'; ch2++){
                
                if(ch1 == ch2)  continue;
                
                StringBuilder sb = new StringBuilder(s);
                
                for(int inx=0; inx<2; inx++){
                    
                    for(int ind=0; ind<n; ind++){
                        ch = sb.charAt(ind);
                        
                        if(ch==ch1){
                            cnt1++;
                        }
                        if(ch==ch2){
                            cnt2++;
                        }
                        
                        if(cnt1<cnt2){
                            cnt1=0;
                            cnt2=0;
                            
                            continue;
                        }
                        
                        if(cnt1!=0 && cnt2!=0){
                            ans = Math.max(ans, cnt1-cnt2);    
                        }
                        
                    }
                    
                    sb = sb.reverse();
                    
                    cnt1=0;
                    cnt2=0;
                }
                
            }
        }
        
        return ans;
    }
}