class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        int max = 0, n=nums.length;
        insert(root, nums[0]);
        
        for(int i=1; i<n; i++){
            max = Math.max(max, helper(root, nums[i]));
            insert(root, nums[i]);
        }
        
        return max;
    }
    
    public int helper(Trie node, int num){
        int bit, ans=0;
        
        for(int i=31; i>=0; i--){
            bit = (num>>i) & 1;
            
            if(bit == 1){
                if(node.zero != null){
                    node = node.zero;
                    ans |= (1<<i);
                }
                else{
                    node = node.one;
                }
            }
            else{
                if(node.one != null){
                    node = node.one;
                    ans |= (1<<i);
                }
                else{
                    node = node.zero;
                }
            }
        }
        
        return ans;
    }
    
    public void insert(Trie node, int n){
        int bit;
        for(int i=31; i>=0; i--){
            bit = (n>>i)&1;
            
            if(bit==1){
                if(node.one == null){
                    node.one = new Trie();
                }
                
                node = node.one;
            }
            else{
                if(node.zero == null){
                    node.zero = new Trie();
                }
                
                node = node.zero;
            }
        }
    }
}

class Trie{
    Trie one, zero;
}