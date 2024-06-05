class Solution {
    public List<String> commonChars(String[] words) {
        int[] arr = new int[26];
        Arrays.fill(arr, (int)1e8);
        
        for(String s : words){
            int[] temp = new int[26];
            int n = s.length();
            
            for(int i=0; i<n; i++){
                temp[s.charAt(i)-'a']++;
            }
            
            for(int i=0; i<26; i++){
                arr[i] = Math.min(arr[i], temp[i]);
            }
        }
        
        List<String> ans = new ArrayList<>();
        
        for(int i=0; i<26; i++){
            if(arr[i]>0 && arr[i]!=(int)1e8){
                while(arr[i]-->0){
                    ans.add((char)('a'+i)+"");
                }
            }
        }
        
        return ans;
    }
}