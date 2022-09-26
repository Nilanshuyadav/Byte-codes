class Solution {
    public boolean equationsPossible(String[] equations) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int ind=0; ind<26; ind++)
            adj.add(new ArrayList<>());
        
        for(String st : equations)
            if(st.charAt(1)=='='){
                adj.get(st.charAt(0)-'a').add(st.charAt(3)-'a');
                adj.get(st.charAt(3)-'a').add(st.charAt(0)-'a');
            }
        
        for(String st : equations)
            if(st.charAt(1)=='!' && (st.charAt(0)==st.charAt(3) || check(st.charAt(0)-'a',st.charAt(3)-'a', adj))) return false;
        
        return true;
    }
    
    public boolean check(int from, int to, List<List<Integer>> adj){
        boolean[] vis = new boolean[26];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(from);
        vis[from] = true;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-->0){
                int temp = q.remove();
                
                for(int ind : adj.get(temp))
                    if(vis[ind] != true){
                        vis[ind] = true;
                        if(ind == to) return true;
                        q.add(ind);
                    }
            }
        }
        
        return false;
    }
}