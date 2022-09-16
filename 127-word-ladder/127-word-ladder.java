class Solution {
    public int ladderLength(String begin, String end, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        
        Set<String> set = new HashSet<>(wordList);
        
        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();
            cnt++;
            
            while(size-->0){
                StringBuilder sb = new StringBuilder(q.remove());
                
                for(int curr_ind = 0;curr_ind<sb.length();curr_ind++)
                    for(int char_ind=0; char_ind<26; char_ind++){
                        StringBuilder modified_string = new StringBuilder(sb.substring(0,curr_ind) + (char)(char_ind+'a') + sb.substring(curr_ind+1));
                        
                        if(set.contains(modified_string.toString())){
                            set.remove(modified_string.toString());
                            q.add(modified_string.toString());
                            
                            if(end.equals(modified_string.toString())) return ++cnt;
                        }
                    }
            }
        }
        
        return 0;
    }
}