class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int cnt=0;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(helper(words[i], words[j])) cnt++;
            }
        }

        return cnt;
    }

    public boolean helper(String a, String b){
        return b.indexOf(a)==0 && b.lastIndexOf(a)==(b.length()-a.length());
    }
}