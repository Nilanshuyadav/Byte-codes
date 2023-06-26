class Solution {
    public int calculate(String s) {
        int temp = 0, total=0;
        Stack<Character> st = new Stack();
        int n = s.length();
        
        st.push('(');
        int ind=0, num=0;
        char ch;
        StringBuilder sb = new StringBuilder("");
        
        while(ind<n){
            ch = s.charAt(ind++);
            
            if(ch == ' ') continue;
            
            if(ch ==')'){
                
                while(true){
                    ch = st.pop();
                    
                    if(ch == '('){
                        if(sb.length() > 0){
                            num = Integer.parseInt(sb.toString());
                            temp += num;
                            
                            sb.setLength(0);
                        }
                        
                        if(st.peek() == '-'){
                            st.pop();
                            temp = -temp;
                        }
                        if(st.peek() == '+'){
                            st.pop();
                        }
                        
                        if(temp < 0){
                            st.push('-');
                            temp = -temp;
                        }
                        else{
                            st.push('+');
                        }
                        
                        String str = String.valueOf(temp);
                        int m = str.length();
                        
                        for(int i=0; i<m; i++){
                            st.push(str.charAt(i));
                        }
                        
                        temp = 0;
                        
                        break;
                    }
                    
                    if(ch!='-' && ch!='+'){
                        sb.insert(0, ch);
                    }
                    else{
                        num = Integer.valueOf(sb.toString());
                        temp += ch=='-' ? -num : num;
                        
                        sb.setLength(0);
                    }
                }
            }
            else{
                st.push(ch);
            }
        }
        
        while(true){
            ch = st.pop();

            if(ch == '('){
                break;
            }

            if(ch!='-' && ch!='+'){
                sb.insert(0, ch);
            }
            else{
                num = Integer.parseInt(sb.toString());
                
                total += ch=='-' ? -num : num;
                sb.setLength(0);
            }
        }
        
        if(sb.length()>0){
            num = Integer.parseInt(sb.toString());
            
            total += num;
        }
        
        return total;
    }
}