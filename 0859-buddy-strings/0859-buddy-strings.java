class Solution {
    public boolean buddyStrings(String s, String goal) {
        int n = s.length(), m=goal.length();
        
        if(n != m)  return false;
        
        int[] fre = new int[26];
        
        for(int ind=0; ind<n; ind++){
            fre[s.charAt(ind)-'a']++;
        }
        
        if(s.equals(goal)){
            for(int ind=0; ind<26; ind++){
                if(fre[ind] > 1){
                    return true;
                }
            }
            
            return false;
        }
        
        int[] arr = new int[2];
        int k=0;
        
        for(int ind=0; ind<n; ind++){
            if(s.charAt(ind) != goal.charAt(ind)){
                if(k<2) arr[k++] = ind;
                else{
                    return false;
                }
            }
        }
        
        if(s.charAt(arr[0]) == goal.charAt(arr[1]) && s.charAt(arr[1])==goal.charAt(arr[0])){
            return true;
        }
        
        return false;
   }
}