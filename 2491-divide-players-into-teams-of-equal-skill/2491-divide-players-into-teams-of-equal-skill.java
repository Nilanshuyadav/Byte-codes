class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        
        int n = skill.length;
        
        int sum = skill[0]+skill[n-1];
        long ans = skill[0]*skill[n-1];
        
        for(int i=1,j=n-2; i<n/2; i++,j--){
            if(skill[i]+skill[j] != sum){
                return -1;
            }
            
            ans += (skill[i]*skill[j]);
        }
        
        return ans;
    }
}