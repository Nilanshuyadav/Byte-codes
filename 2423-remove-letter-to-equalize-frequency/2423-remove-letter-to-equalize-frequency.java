class Solution {
    public boolean equalFrequency(String word) {
        int[] arr = new int[26];
        int n = word.length();
        
        for(int ind=0; ind<n; ind++){
            arr[word.charAt(ind)-'a']++;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int cnt2=0;
        for(int ind=0; ind<26; ind++){
            if(arr[ind] == 0){
                continue;
            }
            
            cnt2++;
            map.put(arr[ind], map.getOrDefault(arr[ind], 0) + 1);
        }
        
        if(cnt2==1){
            return true;
        }
        
        if(map.size()==1 && map.containsKey(1)){
            return true;
        }
        else if(map.size()==2){
            int temp1=0, temp2=0, cnt=0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(cnt==0){
                    temp1 = entry.getKey();
                }
                else{
                    temp2 = entry.getKey();
                }
                
                cnt++;
            }    
            
            if((temp1<temp2 && temp2-temp1==1 && map.get(temp2)==1) || 
               (temp1>temp2 && temp1-temp2==1 && map.get(temp1)==1) || (temp1==1 && map.get(1)==1) || (temp2==1 && map.get(temp2)==1)){
                return true;
            }
        }
        
        return false;
    }
}