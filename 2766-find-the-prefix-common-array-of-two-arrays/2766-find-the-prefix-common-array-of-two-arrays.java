class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        long a=0, b=0;

        for(int i=0; i<n; i++){
            a |= (long)1<<A[i];
            b |= (long)1<<B[i];

            ans[i] = countSetBit(a&b);
        }

        return ans;
    }

    public int countSetBit(long i){
        int cnt = 0;

        while(i>0){
            cnt += i&1;
            i = i>>1;
        }

        return cnt;
    }
}