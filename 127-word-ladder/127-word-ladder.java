class Solution {
    public int ladderLength(String begin, String end, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(begin,1));
        
        Set<String> set = new HashSet<>(wordList);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-->0){
                Pair temp = q.remove();
                
                StringBuilder sb = new StringBuilder(temp.st);
                
                for(int i=0;i<sb.length();i++){
                    for(int j=0;j<26;j++){
                        StringBuilder s = new StringBuilder(sb.substring(0,i) + (char)(j+'a') + sb.substring(i+1));
                        if(set.contains(s.toString())){
                            set.remove(s.toString());
                            q.add(new Pair(s.toString(),temp.level+1));
                            
                            if(end.equals(s.toString())) return temp.level+1;
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}

class Pair{
    String st;
    int level;
    public Pair(String st,int level){
        this.st = st;
        this.level = level;
    }
}