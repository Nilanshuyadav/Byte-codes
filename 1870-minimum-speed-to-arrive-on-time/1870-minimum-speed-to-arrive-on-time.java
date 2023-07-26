class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l=1, h=(int)1e7, m, n=dist.length;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            double temp = canWe(dist, m, n);
            
            if(temp<=hour){
                h = m-1;
            }
            else{
                l = m+1;
            }
        }
        
        return h==(int)1e7 ? -1 : h+1;
    }
    
    public double canWe(int[] dist, int m, int n){
        double sum=0;
        
        for(int ind=0; ind<n; ind++){
            if(ind==n-1){
                sum += ((double)dist[ind])/m;
                break;
            }
            
            sum += Math.ceil((double)dist[ind]/m);
        }
        
        return sum;
    }
}