class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] pre = new int[n+1];
        int cnt = 0, i=1;

        for(String s : words){
            if(isVowel(s.charAt(0)) && isVowel(s.charAt(s.length()-1))){
                cnt++;
            }

            pre[i++] = cnt;
            System.out.print(pre[i-1]+" ");
        }

        int[] ans = new int[queries.length];
        i=0;

        for(int[] q : queries){
            ans[i++] = pre[q[1]+1] - pre[q[0]];
        }

        return ans;
    }

    public boolean isVowel(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}