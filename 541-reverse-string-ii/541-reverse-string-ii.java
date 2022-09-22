class Solution {
    public String reverseStr(String s, int k) {
        Stack<Character> st = new Stack<>();
        
        StringBuilder sb = new StringBuilder(s);
        StringBuilder ans = new StringBuilder("");
        int n = sb.length();
        
        for(int ind=0; ind<n; ind=ind+k+k){
            int a = ind;
            while(a<n && a<ind+k) st.push(sb.charAt(a++));
            while(st.size()!=0) ans.append(st.pop());
            while(a<n && a<ind+k+k) ans.append(sb.charAt(a++));
            
            System.out.println(ans);
        }
        
        return ans.toString();
    }
}