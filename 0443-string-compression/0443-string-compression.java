class Solution {
    public int compress(char[] chars) {
        int n = chars.length, k=0, i=0, j=0, len;
        Stack<Character> st = new Stack<>();
            
        while(i<n){
            if(j<n && chars[i] == chars[j]){
                j++;
            }
            else{
                len = j-i;
                chars[k++] = chars[i];
                
                if(len>1){
                    while(len>0){
                        st.push((char)('0'+(len%10)));
                        len /= 10;
                    }
                    
                    while(!st.isEmpty())    chars[k++] = st.pop();
                }
                
                i=j;
            }
        }
        
        return k;
    }
}