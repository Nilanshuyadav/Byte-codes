class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();

        int diff=0, pre=0;
        for(int ind : target){
            diff = ind-pre-1;

            while(diff-->0){
                ans.add("Push");
                ans.add("Pop");
            }

            ans.add("Push");
            pre = ind;
        }
        return ans;
    }
}