class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int size=0, n=beginWord.length();
        
        for(String st : wordList){
            set.add(st);
        }
        
        if(!set.contains(endWord))   return 0;
        String temp, str;
        int curr_steps=0;
        
        q.add(beginWord);
        char pre;
        
        while(!q.isEmpty()){
            size = q.size();
            curr_steps++;
            
            while(size-->0){
                temp = q.remove();
                
                if(temp.equals(endWord)){
                    return curr_steps;
                }

                StringBuilder sb = new StringBuilder(temp);

                for(int ind=0; ind<n; ind++){
                    pre = sb.charAt(ind);

                    for(char ch='a'; ch<='z'; ch++){
                        sb.setCharAt(ind, ch);
                        str = sb.toString();

                        if(set.contains(str)){
                            set.remove(str);

                            q.add(str);
                        }
                    }

                    sb.setCharAt(ind, pre);
                }    
            }
        
        }
        
        return 0;
    }
}