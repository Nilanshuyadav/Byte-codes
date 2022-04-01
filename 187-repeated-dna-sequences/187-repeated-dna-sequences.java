class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        StringBuilder st = new StringBuilder("");
        
        Map<String,Integer> map1 = new HashMap<>();
        List<String> ans = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            if(i<9) st = st.append(s.charAt(i));
            else if(i==9){
                st.append(s.charAt(i));
                map1.put(st.toString(),1);
            }
            
            else{
                st.append(s.charAt(i));
                st.delete(0,1);
                      
                if(map1.containsKey(st.toString()) && map1.get(st.toString())==1) ans.add(st.toString());
                
                map1.put(st.toString(),map1.getOrDefault(st.toString(),0)+1);
            }
        }
        
       return ans;
    }
}