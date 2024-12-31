class Solution {
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        List<String> al = new ArrayList<>();

        for(int c=0; c<n; c++){
            for(int i=0; i<n; i++){
                if(i==c){
                    sb.append('Q');
                }
                else{
                    sb.append('.');
                }
            }

            al.add(sb.toString());
            helper(1, n, al);

            al.remove(al.size()-1);
            sb.setLength(0);

        }
        
        return ans;
    }

    public void helper(int r, int n, List<String> al){
        if(r==n){
            ans.add(new ArrayList<>(al));
            return;
        }

        StringBuilder sb = new StringBuilder("");

        for(int c=0; c<n; c++){

            if(canWe(r, c, n, al)){
                for(int i=0; i<n; i++){
                    if(i==c){
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    }
                }

                al.add(sb.toString());
                helper(r+1, n, al);

                al.remove(al.size()-1);
                sb.setLength(0);
            }
        }
    }

    public boolean canWe(int r, int c, int n, List<String> al){
        for(int temp_r=r-1; temp_r>=0; temp_r--){
            if(al.get(temp_r).charAt(c)=='Q' || ((c-r+temp_r)>=0 && al.get(temp_r).charAt(c-r+temp_r)=='Q') || ((c+r-temp_r)<n) && al.get(temp_r).charAt(c+r-temp_r)=='Q') return false;
        }

        return true;
    }
}