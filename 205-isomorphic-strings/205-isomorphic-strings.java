class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        
        int[] arr = new int[128];
        Arrays.fill(arr,-1);
        Set<Integer> set = new HashSet<>();
        
        for(int ind=0; ind<n; ind++){
            if((arr[s.charAt(ind)+0]!=-1 && t.charAt(ind)!=arr[s.charAt(ind)+0]-0) ||(arr[s.charAt(ind)+0]==-1 && set.contains(t.charAt(ind)+0))) return false;
            
            arr[s.charAt(ind)+0] = t.charAt(ind)+0;
            set.add(t.charAt(ind)+0);
            
        }
        
        return true;
    }
}