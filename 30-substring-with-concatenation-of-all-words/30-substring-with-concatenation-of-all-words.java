class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> mmap = new HashMap<>();
        for(String st : words)
            mmap.put(st,mmap.getOrDefault(st,0)+1);
        int n = words[0].length() , len = words.length*n;
        
        StringBuilder sb = new StringBuilder(s);
        StringBuilder temp_b = new StringBuilder();
        String temp;
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<sb.length();i++){
            if(i<len-1)
                temp_b.append(sb.charAt(i));
            else{
                if(i == len-1) temp_b.append(s.charAt(i));
                else{
                    temp_b.append(s.charAt(i));
                    temp_b.delete(0,1);
                }
                
                Map<String,Integer> map = new HashMap<>(mmap);
                for(int j =0 ;j<len;j=j+n){
                    temp = temp_b.substring(j,j+n);
                    if(map.containsKey(temp) && map.get(temp)!=0)
                        map.put(temp,map.get(temp)-1);
                    else break;
                    if(j+n == len) ans.add(i-len+1);
                }
            }
        }
        return ans;
    }
}