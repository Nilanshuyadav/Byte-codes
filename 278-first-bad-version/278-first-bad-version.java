/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return dfs(1,n);
    }
    
    public int dfs(int low, int high){
//         if(low==high) if(isBadVersion(low)) return low;
//                       else return low+1;
        
        if(low>high) return low;
        
        int mid = (low)+(high-low)/2;
        
        if(isBadVersion(mid)) return dfs(low,mid-1);
        else return dfs(mid+1,high);
    }
}