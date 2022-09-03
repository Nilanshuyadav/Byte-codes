class Solution {
    HashSet<Integer> ans;
    public int[] numsSameConsecDiff(int n, int k) {
        ans = new HashSet<>();
        for(int i=1;i<=9;i++)
            dfs(0,0,i,n,k);
        
        int[] a = new int[ans.size()];
        int j = 0 ;
        for(int i : ans) a[j++]=i;
        return a;
    }
    
    public void dfs(int ind, int sum, int val,int n,int k){
        if(ind==n){
            ans.add(sum);
            return;
        }
        
        if(val<0 || val>9) return;
        
        sum = (sum*10)+val;
        dfs(ind+1,sum,val+k,n,k);
        dfs(ind+1,sum,val-k,n,k);
    }
}