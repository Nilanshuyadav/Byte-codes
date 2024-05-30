class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length(), m = t.length();
        
        if(n!=m) return false;
        
        int[] arr1= new int[256];
        int[] arr2 = new int[256];
        
        Arrays.fill(arr1, -1);
        Arrays.fill(arr2, -1);
        
        char ch1, ch2;
        
        for(int i=0; i<n; i++){
            ch1 = s.charAt(i);
            ch2 = t.charAt(i);
            
            if(arr1[ch1]==-1){
                arr1[ch1] = ch2;
            }
            if(arr2[ch2]==-1){
                arr2[ch2] = ch1;
            }
            
            if(arr1[ch1]!=ch2 || arr2[ch2]!=ch1) return false;
            
        }
        
        return true;
    }
}