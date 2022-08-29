class Solution {
    public int ladderLength(String start, String end, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        
        Queue<String> q = new LinkedList<>();
        q.add(start);
        
        int cnt = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            cnt++;
            for(int i=0;i<size;i++){
                StringBuilder st = new StringBuilder(q.remove());
                if(end.equals(st.toString())) return cnt;
                for(int j=0;j<st.length();j++)
                    for(int k = 0;k<26;k++){
                        StringBuilder sb = new StringBuilder(st.substring(0,j)+(char)(k+'a')+st.substring(j+1));
                        if(set.contains(sb.toString())){
                            set.remove(sb.toString());
                            q.add(sb.toString());
                        }
                    }
            }
        }
        
        return 0;
    }
}