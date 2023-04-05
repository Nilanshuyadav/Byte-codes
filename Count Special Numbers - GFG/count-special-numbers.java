//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    }
    
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int t = sc.nextInt(); // Inputting the testcases
        PrintWriter out = new PrintWriter(System.out);
        while (t-- > 0) {

            int i = 0;
            int N = sc.nextInt();

            int arr[] = new int[(int)(N)];

            for (i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            Solution ob = new Solution();
            out.println(ob.countSpecialNumbers(N, arr));
        }
        out.flush();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countSpecialNumbers(int N, int arr[]) {
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int ind : arr){
            map.put(ind, map.getOrDefault(ind, 0) + 1);
        }
        
        int cnt=0;
        
        for(int ind : arr){
            if(map.containsKey(ind) && map.get(ind)>1){
                cnt++;
            }
            else if(ind!=1 && map.containsKey(1)){
                cnt++;
            }
            else{
                for(int inx=2; inx<ind/2; inx++){
                    if((ind%inx) == 0 && (find(arr, inx) || find(arr, ind/inx))){
                        cnt++;
                        
                        break;
                    }
                }
            }
        }
        
        return cnt;
    }
    
    public boolean find(int[] arr, int target){
        int l=0, h=arr.length-1, m;
        
        while(l<=h){
            m = l+(h-l)/2;
            
            if(arr[m] == target)    return true;
            else if(arr[m] < target) l=m+1;
            else    h=m-1;
        }
        
        return false;
    }
}