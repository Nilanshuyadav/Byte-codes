//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            boolean ans = obj.isStraightHand(n, k, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean isStraightHand(int N, int groupSize, int hand[]) {
        // code here
        Map<Integer, Integer> map = new TreeMap<>();
        
        for(int ind : hand){
            map.put(ind, map.getOrDefault(ind, 0) + 1);
        }
        
        while(!map.isEmpty()){
            if(!findGroups(groupSize, map))
                return false;
        }
        
        return true;
    }
    
    static boolean findGroups(int size, Map<Integer, Integer> map){
        int cnt = 0, pre = -1, curr;
        List<Integer> al = new ArrayList<>();
        boolean ans = false;
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(cnt==0){
                pre = entry.getKey();
            }
            else{
                curr = entry.getKey();
                
                if(curr != pre+1){
                    break;
                }
                
                pre = curr;
            }
            
            map.put(pre, map.get(pre)-1);
                
            if(map.get(pre) == 0){
                al.add(pre);
            }
            
            cnt++;
            
            if(cnt == size){
                ans = true;
                break;
            }
        }
        
        for(int ind : al){
            map.remove(ind);
        }
        
        return ans;
    }
}
