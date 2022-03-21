class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int n = s.length();
        
        List<Integer> ans = new ArrayList<>();
        int[] arr = new int[26];
        
        for(int i=0;i<n;i++) arr[s.charAt(i)-'a'] = i;
        
        
        for(int i=0;i<n;i++){
            
            int max = arr[s.charAt(i)-'a'];
            int len = 1;
            
            while(i<max){
                if(arr[s.charAt(i)-'a']>max) max = arr[s.charAt(i)-'a'];
                len++;
                
                i++;
            }
            
            ans.add(len);
            
        }
        
        return ans;
    }
}