class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        
        Queue<String> q = new LinkedList<>();
        
        if(!set.contains("0000")){
            q.add("0000");    
        }
        
        int size, steps=0;
        String curr, next_st, pre_st;
        
        while(!q.isEmpty()){
            size = q.size();
            
            while(size-->0){
                curr = q.remove();
                
                if(curr.equals(target)){
                    return steps;
                }
                
                for(int i=0; i<4; i++){
                    next_st = next(curr, i);
                    if(!set.contains(next_st)){
                        set.add(next_st);
                        q.add(next_st);
                    }
                    
                    pre_st = pre(curr, i);
                    if(!set.contains(pre_st)){
                        set.add(pre_st);
                        q.add(pre_st);
                    }
                }
                
            }
            
            steps++;
        }
        
        return -1;
    }
    
    public String next(String st, int ind){
        char[] arr = st.toCharArray();
        
        if(arr[ind]=='9'){
            arr[ind] = '0';
        }
        else{
            arr[ind]++;
        }
        
        return String.valueOf(arr);
    }
    
    public String pre(String st, int ind){
        char[] arr = st.toCharArray();
        
        if(arr[ind]=='0'){
            arr[ind] = '9';
        }
        else{
            arr[ind]--;
        }
        
        return String.valueOf(arr);
    }
}