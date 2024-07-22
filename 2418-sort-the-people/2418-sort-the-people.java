class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new TreeMap<>();
        int n = heights.length;
        
        for(int i=0; i<n; i++){
            map.put(heights[i], names[i]);
        }
        
        String[] ans = new String[n];
        int ind=n-1;
        
        for(String st : map.values()){
            ans[ind--] = st;
        }
        
        return ans;
    }
}