class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        
        long c;
        
        for(int i=1;i<=numRows;i++){
            c = 1;
            List<Integer> al = new ArrayList<>();
            
            for(int j = 1;j<i;j++){
                al.add((int)c);
                
                c = (c*(i-j))/j;
            }
            al.add(1);
            
            ans.add(al);
        }
        
        return ans;
    }
}