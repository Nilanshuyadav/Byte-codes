class Solution {
    public List<Integer> getRow(int rowIndex) {
     
        ArrayList<Integer> ans = new ArrayList<>();
        
        rowIndex++;
        long c=1;
        
        for(int i=1;i<=rowIndex;i++){
            ans.add((int)c);
            
            c = c*(rowIndex-i)/i;
        }
        
        return ans;
    }
}