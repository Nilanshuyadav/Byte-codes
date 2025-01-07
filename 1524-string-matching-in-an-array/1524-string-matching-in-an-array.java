class Solution {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words);
        
        int n = words.length;
        List<String> ans = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(words[j].indexOf(words[i]) != -1){
                    ans.add(words[i]);
                    break;
                }
            }
        }
        
        return ans;
    }
}