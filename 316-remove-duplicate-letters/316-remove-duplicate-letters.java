class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        
        int[] effect = new int[26];
        boolean[] visited = new boolean[26];
        
        Stack<Character> stack = new Stack();
        
        for(int i=0;i<n;i++){ effect[s.charAt(i)-'a']=  i;}
        
        //Arrays.fill(visited,Boolean.FALSE);
        
        stack.push(s.charAt(0));
        visited[s.charAt(0)-'a'] = true;
        for(int i=1;i<n;i++){
            if(visited[s.charAt(i)-'a']) continue;
            while(!stack.isEmpty() && s.charAt(i)<stack.peek() && effect[stack.peek()-'a']> i)
                visited[stack.pop()-'a'] = false;
            stack.push(s.charAt(i));
            visited[s.charAt(i) - 'a'] = true;
             //(effect[stack.peek() - 'a']<=i)
              
        }
        
        StringBuilder ans = new StringBuilder("");
        n=stack.size();
        for(int i=0;i<n;i++)
            ans.append(stack.pop());
        
        return ans.reverse().toString();
    }
}