class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int al = ax2-ax1;
        int ab = ay2-ay1;

        int area1 = al*ab;

        int bl = bx2-bx1;
        int bb = by2-by1;

        int area2 = bl*bb;

        int yu=0, yn=0, xl=0, xr=0;

        if(ay2>=by2 && by2>=ay1){
            yu = by2;
        }
        if(ay2>=by1 && by1>=ay1){
            yn = by1;
        }
        if(ax1<=bx1 && bx1<=ax2){
            xl = bx1;
        }
        if(ax1<=bx2 && bx2<=ax2){
            xr = bx2;
        }

        if(by2>=ay2 && ay2>=by1){
            yu = ay2;
        }
        if(by2>=ay1 && ay1>=by1){
            yn = ay1;
        }
        if(bx1<=ax1 && ax1<=bx2){
            xl = ax1;
        }
        if(bx1<=ax2 && ax2<=bx2){
            xr = ax2;
        }

        int il = xr-xl;
        int ib = yu-yn;

        int area3 = il*ib;

        return area1+area2-area3;
    }
}