class Solution {
public:
    vector<int> shuffle(vector<int>& nums, int n) {
        vector<int> res;
        
        for(int ind=0; ind<n; ind++){
            res.push_back(nums[ind]);
            res.push_back(nums[ind+n]);
        }
        
        return res;
    }
};