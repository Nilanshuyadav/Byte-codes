class Solution {
    int cnt=0;
    public int maximumGain(String s, int x, int y) {
        return x>y ? ab(s, x, y) : ba(s, x, y);     
    }
    
    public int ab(String s, int x, int y){
        Stack<Character> st = new Stack<>();
        int n = s.length(), sum = 0;
        char ch;
        StringBuilder sb = new StringBuilder(""), temp = new StringBuilder("");
        
        for(int i=0; i<n; i++){
            ch = s.charAt(i);
            
            if(ch == 'a'){
                st.add(ch);
            }
            else if(ch == 'b' && !st.isEmpty()){
                st.pop();
                sum += x;
            }
            else{
                if(!st.isEmpty()){
                    while(!st.isEmpty()){
                        temp.append(st.pop());
                    }    
                    
                    sb.append(temp);
                    
                    temp.setLength(0);
                }
                
                sb.append(ch);
            }
        }
        
        while(!st.isEmpty()){
            temp.append(st.pop());
        }    

        sb.append(temp);
        
                
        return ++cnt==2 ? sum : sum+ba(sb.toString(), x, y);
    }
    
    public int ba(String s, int x, int y){
        Stack<Character> st = new Stack<>();
        int n = s.length(), sum = 0;
        char ch;
        StringBuilder sb = new StringBuilder(""), temp = new StringBuilder("");
        
        for(int i=0; i<n; i++){
            ch = s.charAt(i);
            
            if(ch == 'b'){
                st.add(ch);
            }
            else if(ch == 'a' && !st.isEmpty()){
                st.pop();
                sum += y;
            }
            else{
                if(!st.isEmpty()){
                    while(!st.isEmpty()){
                        temp.append(st.pop());
                    }    
                    
                    sb.append(temp);
                    
                    temp.setLength(0);
                }
                
                sb.append(ch);
            }
        }
        
        while(!st.isEmpty()){
            temp.append(st.pop());
        }    

        sb.append(temp);
        
        
        return ++cnt==2 ? sum : sum+ab(sb.toString(), x, y);
    }
}