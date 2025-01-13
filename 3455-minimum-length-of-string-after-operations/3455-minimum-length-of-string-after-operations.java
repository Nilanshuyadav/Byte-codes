class Solution {
    public int minimumLength(String s) {
        int[] fre = new int[26];
        int n = s.length();

        for(int i=0; i<n; i++){
            fre[s.charAt(i)-'a']++;
        }

        int cnt=0;

        for(int i : fre){
            if (i==0) continue;
            cnt += (i&1)==0 ? 2 : 1;
        }

        return cnt;
    }
}