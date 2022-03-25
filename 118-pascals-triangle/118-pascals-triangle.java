class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        for(int i=0;i<numRows;i++){
            long c = 1;
            int r = i+1;
            List<Integer> temp = new ArrayList<Integer>();
            for(int j=1;j<r;j++){
                temp.add((int)c);
                c = c*(r-j)/j;
            }
            temp.add(1);
            
            ans.add(temp);
        }
        return ans;
    }
}