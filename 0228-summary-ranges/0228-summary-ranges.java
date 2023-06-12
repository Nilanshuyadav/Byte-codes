class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        
        if(n == 0){
            return new ArrayList<>();
        }
        
        int start=nums[0], end;
        
        List<String> al = new ArrayList<>();
        
        for(int ind=1; ind<n; ind++){
            if(nums[ind-1]+1!=nums[ind]){
                end = nums[ind-1];
                
                if(start == end){
                    String st = String.valueOf(start);
                    
                    al.add(st);
                }
                else{
                    String st = String.valueOf(start)+"->"+String.valueOf(end);
                    
                    al.add(st);
                }
                
                start = nums[ind];
            }        
        }
        
        end = nums[n-1];
        
        if(start == end){
            String st = String.valueOf(start);
            
            al.add(st);
        }
        else{
            String st = String.valueOf(start)+"->"+String.valueOf(end);
            
            al.add(st);
        }
        
        return al;
    }
}