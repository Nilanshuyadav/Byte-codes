class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        
        int[] arr = new int[26];
        
        for(int i=0;i<n;i++)
            arr[s.charAt(i) - 'a']=i;
        
        List<Integer> ans = new ArrayList<>();
        
        
        
        for(int i=0;i<n;i++){
            int max = arr[s.charAt(i)-'a'];
            int len = 0;
            
            while(i <= max){
                if(arr[s.charAt(i)-'a'] > max) max = arr[s.charAt(i)-'a'];
                len++;
                i++;
            }
            i--;
            
            ans.add(len);
        }
        
        return ans;
    }
}