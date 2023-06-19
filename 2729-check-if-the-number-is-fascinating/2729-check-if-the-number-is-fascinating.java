class Solution {
    public boolean isFascinating(int n) {
        int two_n = 2*n;
        int three_n = 3*n;
        
        String st = ""+n+two_n+three_n;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        
        for(int ind=0; ind<9; ind++){
            set.add(st.charAt(ind)-'0');
        }
        
        return set.size()==10;
    }
}