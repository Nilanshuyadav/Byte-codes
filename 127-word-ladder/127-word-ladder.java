class Solution {
    public int ladderLength(String begin, String end, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        
        Queue<StringBuilder> q = new LinkedList<>();
        q.add(new StringBuilder(begin));
        
        int cnt = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            cnt++;
            while(size-->0){
                StringBuilder st = new StringBuilder(q.remove());
                if(end.equals(st.toString())) return cnt;
                
                for(int i=0;i<st.length();i++){
                    for(int j=0;j<26;j++){
                        StringBuilder s = new StringBuilder(st.substring(0,i) + (char)(j+'a') + st.substring(i+1));
                        if(set.contains(s.toString())){set.remove(s.toString()); q.add(s); }
                    }    
                }
            }
        }
        
        return 0;
    }
}