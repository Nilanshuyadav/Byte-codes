//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int test = Integer.parseInt(in.readLine().trim());
        while(test-- > 0){
            int n = Integer.parseInt(in.readLine().trim());
            int m = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int [] seats = new int[m];
            for(int i = 0; i < m; i++){
                seats[i] = Integer.parseInt(s[i]);
            }
            Solution obj = new Solution();
            boolean res = obj.is_possible_to_get_seats(n, m, seats);
            
            String _result_val = (res) ? "Yes" : "No";
            out.println(_result_val);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static boolean is_possible_to_get_seats(int n, int m, int[] seats) {
        int total = 0;
        
        List<Integer> al = new ArrayList<>();
        
        al.add(-2);
        for(int ind=0; ind<m; ind++){
            if(seats[ind] == 1){
                al.add(ind);
            }
        }
        
        al.add(m+1);
        int between;
        
        int pre = al.get(0);
        for(int ind=1; ind<al.size(); ind++){
            between = al.get(ind)-pre-1;
            
            total += (between-1)/2;
            pre = al.get(ind);
        }
        
        return n<=total;
    }
}
        
