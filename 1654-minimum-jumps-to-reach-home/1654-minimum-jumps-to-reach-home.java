class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Queue<Pair> q = new LinkedList<>();
        Set<Integer> set = Arrays.stream(forbidden).boxed().collect(Collectors.toSet());
        Set<String> visited = new HashSet<>();
        
        //if(x == 0) return 0;
        
        q.add(new Pair(0,false));
//         visited.add(new StringBuilder().append(0).append('f').toString());
        
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0;i<size;i++){
                Pair temp = q.remove();

                if(temp.curr == x) return step;

                int new_curr = temp.curr + a;
                String temp2 = new StringBuilder()
                               .append(new_curr)
                               .append('f')
                               .toString();

                if(new_curr < 6000 
                   && !visited.contains(temp2) 
                   && !set.contains(new_curr))
                {
                    q.add(new Pair(new_curr,false));
                    visited.add(temp2);
                }

                if(!temp.backward){
                    new_curr = temp.curr - b;
                    temp2 = new StringBuilder()
                           .append(new_curr)
                           .append('t').toString();
                    if(new_curr >=0 
                       && !visited.contains(temp2) 
                       && !set.contains(new_curr))
                    {
                        q.add(new Pair(new_curr,true));
                        visited.add(temp2);
                    }
                }
            }
         step++;   
        }
        return -1;
    }
}

class Pair{
    int curr;
    boolean backward;
    public Pair(int curr, boolean backward){
        this.curr = curr;
        this.backward = backward;
    }
}