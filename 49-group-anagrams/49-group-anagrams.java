class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
                
        Map<String,List<String>> map = new HashMap();
        
        for(String i:strs){
            String s = i;
            
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            s = new String(ch);
            
            if(map.containsKey(s)){
                List<String> temp = map.get(s);
                temp.add(i);
                map.put(s,temp);
            }
            else{
                List<String> temp2 = new ArrayList<>();
                temp2.add(i);
                map.put(s,temp2);
            }
        }
        
        List<List<String>> ans = new ArrayList<List<String>>();
        
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        
        return ans;
    }
}