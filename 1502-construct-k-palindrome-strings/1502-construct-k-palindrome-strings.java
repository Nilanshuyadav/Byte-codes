class Solution {
    public boolean canConstruct(String s, int k) {
        int[] arr = new int[26];
        int n = s.length();

        for(int i=0; i<n; i++){
            arr[s.charAt(i)-'a']++;
        }

        int cnt=0;
        for(int i : arr){
            cnt += i&1;
        }

        return cnt<=k && n>=k;
    }
}