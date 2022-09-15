class Solution {
    public int[] findOriginalArray(int[] changed) {
        int[] freq = new int[100001];
        int n = changed.length;
        if(n%2 != 0) return new int[0];
        
        int a=0 ,ans[] = new int[n/2];
        
        for(int i : changed)
            freq[i]++;
        
        if(freq[0]%2 !=0) return new int[0];
        while(freq[0]-->0){
            ans[a++] = 0;
            freq[0]--;
        }
        
        for(int i=1;i<100002/2;i++){
            if(freq[2*i]<freq[i]) return new int[0];
            freq[2*i] -= freq[i];
            while(freq[i]-->0)
                ans[a++] = i;
        }
        
        return a!=n/2?new int[0] : ans;
    }
}