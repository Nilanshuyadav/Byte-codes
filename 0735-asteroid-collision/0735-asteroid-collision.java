class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        boolean bool;
        
        for(int ind : asteroids){
            if(st.isEmpty() || (st.peek()<0 && ind>0) || (ind>0 && st.peek()>0) || (ind<0 && st.peek()<0)){
                st.push(ind);
            }
            else{   
                bool = false;
                while(!st.isEmpty() && st.peek()>0 && st.peek()<=-ind){
                    if(st.peek() == -ind){
                        st.pop();
                        bool = true;
                        break;
                    }
                    
                    st.pop();
                }
                
                if(!bool && (st.isEmpty() || st.peek()<0)){
                    st.push(ind);
                }
            }
        }
        
        int n = st.size();
        int[] arr = new int[n];
        
        for(int ind=n-1; ind>=0; ind--){
            arr[ind] = st.pop();
        }
        
        return arr;
    }
}