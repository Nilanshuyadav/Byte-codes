class Solution {
    public int[] searchRange(int[] nums, int tar) {
        int start, end;
        int n = nums.length;

        if(n==0) return new int[]{-1, -1};

        start = binSearch(nums, tar, n);

        if(start==n || nums[start] != tar) return new int[]{-1, -1};
        
        end = binSearch(nums, tar+1, n);

        return new int[]{start, end-1};
    }

    public int binSearch(int[] nums, int tar, int n){
        int l=0, r=n, m;

        while(l<r){
            m = l + (r-l)/2;
            if(nums[m] < tar) l = m+1;
            else r = m;
        }

        return r;
    }
}