class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int size=0, n=beginWord.length();
        
        for(String st : wordList){
            set.add(st);
        }
        
        if(!set.contains(endWord))   return 0;
        String curr_st, str;
        int curr_steps;
        
        q.add(new Pair(beginWord, 1));
        Pair temp;
        char pre;
        
        while(!q.isEmpty()){
            temp = q.remove();

            curr_st = temp.st;
            curr_steps = temp.steps;

            if(curr_st.equals(endWord)){
                return curr_steps;
            }

            StringBuilder sb = new StringBuilder(curr_st);

            for(int ind=0; ind<n; ind++){
                pre = sb.charAt(ind);

                for(char ch='a'; ch<='z'; ch++){
                    sb.setCharAt(ind, ch);
                    str = sb.toString();

                    if(set.contains(str)){
                        set.remove(str);

                        q.add(new Pair(str, curr_steps+1));
                    }
                }

                sb.setCharAt(ind, pre);
            }
        
        }
        
        return 0;
    }
}

class Pair{
    String st;
    int steps;
    
    public Pair(String st, int steps){
        this.st = st;
        this.steps = steps;
    }
}