class Solution {
    int[] target = new int[26];
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int n = words1.length, m= words2.length;
        int cnt = 0;
        
        int[] arr = new int[26];
        
        for(String s:words2){
            for(char ch : s.toCharArray()){
                arr[ch - 'a']++;
                target[ch-'a'] = Math.max(target[ch - 'a'],arr[ch-'a']);
            }
            Arrays.fill(arr,0);
        }
        
        
        List<String> ans = new ArrayList<>();
        
        for(String s : words1){
            if(check(s))
                ans.add(s);
        }
        
        return ans;
    }
    
    public boolean check(String s){
        int[] arr = new int[26];
        
        for(char ch : s.toCharArray())
            arr[ch-'a']++;
        
        for(int i =0;i<26;i++)
            if(arr[i] < target[i]) return false;
        
        return true;
    }
}