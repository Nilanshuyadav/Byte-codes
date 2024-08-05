class Solution {
    public String kthDistinct(String[] arr, int k) {
        Set<String> s1 = new HashSet<>(), s2 = new HashSet<>();
        
        for(String s : arr){
            if(!s1.add(s)){
                s2.add(s);
            }
        }
        
        for(String s : s2){
            s1.remove(s);
        }
        
        for(String s : arr){
            if(s1.contains(s)){
                k--;
            }
            
            if(k==0){
                return s;
            }
        }
        
        return "";
    }
}