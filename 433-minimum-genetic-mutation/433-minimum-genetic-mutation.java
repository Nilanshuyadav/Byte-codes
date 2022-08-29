class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        for(String s : bank) set.add(s);
        
        if(!set.contains(end)) return -1;
        
        // Set<String> vis = new HashSet<>();
        // vis.add(start);
        
        Queue<String> q = new LinkedList<>();
        q.add(start);
        int cnt = -1;
        
        String[] carr = {"A","C","G","T"};
        
        while(!q.isEmpty()){
            cnt++;
            int size = q.size();
            for(int i=0;i<size;i++){
                StringBuilder st = new StringBuilder(q.remove());
                if(end.equals(st.toString())) return cnt;
                for(int j=0;j<st.length();j++){
                    for(int k=0;k<4;k++){
                        StringBuilder sb = new StringBuilder(
                            st.substring(0,j)+carr[k]+st.substring(j+1));
                        if(set.contains(sb.toString())){
                            //vis.add(sb.toString());
                            set.remove(sb.toString());
                            q.add(sb.toString());
                        }
                    }
                }
            }
        }
        return -1;
    }
}