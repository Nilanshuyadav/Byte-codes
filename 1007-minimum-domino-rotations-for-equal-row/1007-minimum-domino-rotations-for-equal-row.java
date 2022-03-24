class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
         int n = tops.length;
        int count1 =0 ,count2=0,count3=0,count4=0;
        int f1 = 0,f2=0,f3=0,f4=0;
        
        int t = tops[0];
        int b = bottoms[0];
        
        for(int i=0;i<n;i++){
            if(count1 < Integer.MAX_VALUE){
                if(tops[i] == t);
                else if(bottoms[i] == t) count1++;
                else count1 = Integer.MAX_VALUE;
            }
            
            if(count2 < Integer.MAX_VALUE){
                if(bottoms[i] == t);
                else if(tops[i] == t) count2++;
                else count2 = Integer.MAX_VALUE;
            }
            
            if(count3 < Integer.MAX_VALUE){
                if(tops[i] == b);
                else if(bottoms[i] == b) count3++;
                else count3 = Integer.MAX_VALUE;
            }
            
            if(count4 < Integer.MAX_VALUE){
                if(bottoms[i] == b);
                else if(tops[i] == b) count4++;
                else count4 = Integer.MAX_VALUE;
            }
        }
        
        int result = Math.min(count1,count2);
        result = Math.min(result,count3);
        result = Math.min(result,count4);
        return result == Integer.MAX_VALUE?-1:result;
    }
}