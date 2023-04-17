class Solution {
    public int addMinimum(String word) {
        int n = word.length();
        int cnt=0;
        StringBuilder sb = new StringBuilder(word);
        
        if(sb.charAt(n-1) != 'c'){
            cnt++;
            sb.append('c');
        }
        
        if(sb.charAt(0) != 'a'){
            cnt++;
            sb.insert(0, 'a');
            
        }
        
        
        for(int ind=1; ind<sb.length(); ind++){
            if(sb.charAt(ind-1) == 'a' && sb.charAt(ind) != 'b'){
                sb.insert(ind, 'b');
                cnt++;
            }
            
            else if(sb.charAt(ind-1) == 'b' && sb.charAt(ind) != 'c'){
                sb.insert(ind, 'c');
                cnt++;
            }
            else if(sb.charAt(ind-1) == 'c' && sb.charAt(ind) != 'a'){
                sb.insert(ind, 'a');
                cnt++;
            }
            
        }
        
        return cnt;
    }
}