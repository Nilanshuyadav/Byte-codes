class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length, 
            j=0, max,
            q_len = queries.length,
            ans[] = new int[q_len],
            x, m, ind, inx;
        Arrays.sort(nums);
        
        List<int[]> arr = new ArrayList<>();
        
        for(int i=0; i<q_len; i++){
            arr.add(new int[]{queries[i][0], queries[i][1], i});
        }
        
        Collections.sort(arr, (a, b) -> a[1]<=b[1] ? -1 : 1);
        
        Trie root = new Trie();
        
        for(int[] q : arr){
            x = q[0];
            m = q[1];
            inx = q[2];
            
            ind = findTar(nums, n, m+1);

            if(ind == 0){
                ans[inx] = -1;
                continue;
            }
            while(j<ind){
                insert(nums[j++], root);
            }
            
            max = helper(root, x);
            ans[inx] = max;
        }
        
        return ans;
    }
    
    public int helper(Trie node, int n){
        int bit, ans=0;
        
        for(int i=31; i>=0; i--){
            bit = (n>>i) & 1;
            
            if(bit>0){
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
    
    public void insert(int n, Trie node){
        int bit;
        
        for(int i=31; i>=0; i--){
            bit = (n>>i) & 1;
            
            if(bit>0){
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
    
    public int findTar(int[] nums, int n, int m){
        int l=0, r=n-1, mid;
        
        while(l<=r){
            mid = l + (r-l)/2;
            
            if(nums[mid] >= m){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        
        return l;
    }
}

class Trie{
    Trie one, zero;
}