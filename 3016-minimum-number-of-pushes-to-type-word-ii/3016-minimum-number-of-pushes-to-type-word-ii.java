class Solution {
    public int minimumPushes(String word) {
        int cnt=0, mul=1, fre[] = new int[26];
        
        for(char ch : word.toCharArray()){
            fre[ch-'a']++;
        }
        
        Arrays.sort(fre);
        int temp, l=0, r=25;
        
        while(l<r){
            temp = fre[l];
            fre[l] = fre[r];
            fre[r] = temp;
            l++;
            r--;
        }
        
        int ans=0;
        
        for(int i : fre){
            if(i == 0) continue;
            
            ans += (i*mul);
            cnt++;
            
            if(cnt%8 == 0){
                mul++;
            }
            
        }
        
        return ans;
    }
}