class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int l=1, h=maxSum, m, ans;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(canWe(m, n, index, maxSum)){
                ans = m;
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        
        return h;
    }
    
    public boolean canWe(long m, int n, int index, int maxSum){
        long total = 0;
        
        long r = m-1, r_len=n-1 - index;
        long l = m-1, l_len=index;
        
        long temp;
        
        if(r >= r_len){
            temp = r-r_len;
            
            total += ((r)*(r+1))/2 - ((temp)*(temp+1))/2;
        }
        else{
            total += ((r)*(r+1))/2 + r_len-r;
        }
        
        
        if(l >= l_len){
            temp = l-l_len;
            
            total += ((l)*(l+1))/2 - ((temp)*(temp+1))/2;
        }
        else{
            total += ((l)*(l+1))/2 + l_len-l;
        }
        
        total += m;
        
        return total<=maxSum;
       
        
//         long r = Math.max(0, m - (n-1 - index) - 1);
//         long l = Math.max(0, m - index - 1);
        
//         total += (((m)*(m+1))/2) - (((r)*(r+1))/2) + Math.max(0, (n-1 - m + 1));
//         m = m-1;
        
//         total += (((m)*(m+1))/2) - (((l)*(l+1))/2) + Math.max(0, index-m+2);
        
//         return total<=maxSum;
    }
}