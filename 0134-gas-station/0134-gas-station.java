class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        
        int gas_sum=0, cost_sum=0, temp;
        
        for(int ind=0; ind<n; ind++){
            gas_sum += gas[ind];
            cost_sum += cost[ind];
        }
        
        if(cost_sum>gas_sum)
            return -1;
        
        for(int ind=0; ind<n; ind++){
            if(cost[ind]<=gas[ind]){
                temp = solve(gas, cost, n, ind);
                
                if(temp==n)
                    return ind;
                ind=temp;
            }
        }
        
        return -1;
    }
    
    public int solve(int[] gas, int[] cost, int n, int start_ind){
        int tank=0, ind;
        
        for(ind = start_ind; ind<n; ind++){
            tank += gas[ind];
            if(cost[ind]>tank)
                return ind;
            tank -= cost[ind];
        }
        
        return ind;
    }
}