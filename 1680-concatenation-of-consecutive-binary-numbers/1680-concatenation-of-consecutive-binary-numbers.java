class Solution {
    public int concatenatedBinary(int n) {
        // StringBuilder sb = new StringBuilder("");
        // for(int ind=1; ind<=n; ind++){
        //     sb.append(Integer.toBinaryString(ind));
        // }
        
        // System.out.println(sb.length());
        // long st = Long.parseLong(sb.toString(),2);
        // int sum=0;
        // sb = sb.reverse();
        // for(int ind=0; ind<sb.length(); ind++)
        //     if(sb.charAt(ind)=='1'){ sum = (int)(((double)sum+Math.pow(2,ind))%1000000007); System.out.println(sum);}       
        // return (int)sum;//(int)(st%1000000007);
        
        long digitToShift = 0;
        long sum = 0;
        
        for(int ind=1; ind<=n; ind++){
            if((ind & (ind-1)) == 0) digitToShift++;
            
            sum = (sum<<digitToShift | ind)%1000000007;
        }
        return (int)sum;
    }
}