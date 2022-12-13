class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        if(s.charAt(n-1) == '1')
            return false;

        Queue<Integer> q = new LinkedList<>();
        int last = 0;

        q.add(0);
        boolean[] vis = new boolean[n];
        vis[0] = true;

        while(!q.isEmpty()){
            int temp = q.remove();

            int from = Math.max(last,temp+minJump);
            int to = Math.min(n-1, temp+maxJump);

            for(int inx=from; inx<=to; inx++){
                if(inx == n-1)
                    return true;
                if(s.charAt(inx)=='1')
                    continue;

                if(!vis[inx]){
                    vis[inx] = true;
                    q.add(inx);
                }        
            }

            last = to;
        }

        return false;
    }
}