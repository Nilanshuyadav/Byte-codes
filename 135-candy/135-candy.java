class Solution {
    public int candy(int[] ratings) {
        int l1[]=new int[ratings.length];
        int r1[]=new int[ratings.length];
        
        for (int i=0;i<l1.length;i++)
        {
            l1[i]=1;
        }
        for (int i=0;i<r1.length;i++)
        {
            r1[i]=1;
        }
        
        for (int i=1;i<l1.length;i++)
        {
            if (ratings[i]> ratings[i-1])
            {
                l1[i]=l1[i-1]+1;
            }
        }
         for (int i=r1.length-2;i>=0;i--)
        {
            if (ratings[i]>ratings[i+1])
            {
                r1[i]=r1[i+1]+1;
            }
        }
        int sum=0;
        for (int i=0;i<ratings.length;i++)
        {
            sum+=Math.max(l1[i],r1[i]);
         
        }
        
        return sum;
    }
}