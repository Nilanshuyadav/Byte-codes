/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
       return dfs(1,n);
    }
    
    public int dfs(int l, int h){
        int m = l + (h-l)/2;
        
        int temp = guess(m);
        
        if(temp==0) return m;
        else if(temp==-1) return dfs(l,m-1);
        else return dfs(m+1,h);
    }
}