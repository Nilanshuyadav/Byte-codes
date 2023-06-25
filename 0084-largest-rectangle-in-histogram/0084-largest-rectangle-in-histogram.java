class Solution {
    public int largestRectangleArea(int[] height) {
        int n = height.length;
        
        int[] left = new int[n], right = new int[n];
        
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        
        for(int ind=0; ind<n; ind++){
            while(st.size()>1 && height[st.peek()] >= height[ind]){
                st.pop();
            }
            
            left[ind] = st.peek();
            st.push(ind);
        }
        
        st.clear();
        st.push(n);
        for(int ind=n-1; ind>=0; ind--){
            while(st.size()>1 && height[st.peek()]>=height[ind]){
                st.pop();
            }
            
            right[ind] = st.peek();
            st.push(ind);
        }
        
        int ans=0, length;
        for(int ind=0; ind<n; ind++){
            length = right[ind]-left[ind]-1;
            ans = Math.max(ans, length*height[ind]);
        }
        
        return ans;
    }
}