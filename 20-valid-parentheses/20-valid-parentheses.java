class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        
        Stack<Character> stack = new Stack();
        
        if(n%2 != 0) return false;
        
        for(int i=0;i<n;i++){
            if(s.charAt(i) == ']' && stack.size()!=0 && stack.peek() == '[')
                stack.pop();
            
            else if(s.charAt(i) == '}' && stack.size()!=0 &&  stack.peek() == '{')
                stack.pop();
            
            else if(s.charAt(i) == ')' && stack.size()!=0 && stack.peek() == '(')
                stack.pop();
            
            else stack.push(s.charAt(i));
        }
        
        if(stack.size() == 0) return true;
        return false;
    }
}