class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        int n = nums.length;

        helper(0, new ArrayList<>(), n, nums);
        return ans;
    }

    public void helper(int ind, List<Integer> al, int n, int[] nums){
        if(ind == n){
            ans.add(new ArrayList<>(al));
            return;
        }

        al.add(nums[ind]);
        helper(ind+1, al, n, nums);

        al.remove(al.size()-1);
        helper(ind+1, al, n, nums);
    }
}