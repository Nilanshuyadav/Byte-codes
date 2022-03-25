class Solution {
    public int twoCitySchedCost(int[][] costs) {
     
        int r = costs.length;
        int c = costs[0].length;
        
        Arrays.sort(costs,(a,b)->{
            return (a[0]-a[1])-(b[0]-b[1]);
        });
                
        int price = 0;
        
        for(int i=0;i<r/2;i++)
            price += costs[i][0];
        
        for(int i=r/2 ;i<r;i++)
            price += costs[i][1];
        
        return price;
            
    }
}