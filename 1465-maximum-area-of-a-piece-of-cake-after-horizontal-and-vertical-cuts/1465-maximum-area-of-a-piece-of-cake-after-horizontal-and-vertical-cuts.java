class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long mod = (long)1e9+7;
        
        long max_horizontal_cut = horizontalCuts[0] - 0;
        long max_vertical_cut = verticalCuts[0] - 0;
        
        int horizontal_length = horizontalCuts.length;
        int vertical_length = verticalCuts.length;
        
        //For horizontal max;
        
        for(int i = 1;i<horizontal_length;i++) 
            if(horizontalCuts[i] - horizontalCuts[i-1] > max_horizontal_cut) 
                max_horizontal_cut = horizontalCuts[i] - horizontalCuts[i-1];
        
        if(h - horizontalCuts[horizontal_length-1] > max_horizontal_cut) 
            max_horizontal_cut = h - horizontalCuts[horizontal_length-1];
        
        //For vertical max;
        
        for(int i = 1;i<vertical_length;i++)
            if(verticalCuts[i] - verticalCuts[i-1] > max_vertical_cut)
                max_vertical_cut = verticalCuts[i] - verticalCuts[i-1];
        
        if(w - verticalCuts[vertical_length-1] > max_vertical_cut) 
            max_vertical_cut = w - verticalCuts[vertical_length-1];
        
        return (int)((max_horizontal_cut * max_vertical_cut)%mod);
    }
}