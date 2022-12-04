//{ Driver Code Starts
//Initial Template for Java

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
      List<List<String>> accounts=new ArrayList<>();
      for (int i = 0; i < n; i++)
       {
        ArrayList<String> temp=new ArrayList<>();
        int x=sc.nextInt();
        for(int j = 0; j < x; j++)
           {
             String s1=sc.next();
             temp.add(s1);
           }
        accounts.add(temp);
       }
      Solution obj = new Solution();
      List<List<String>> res = obj.accountsMerge(accounts);
      Collections.sort(res, new Comparator<List<String>>() {
                @Override   public int compare(List<String> a,
                                              List<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        String xx=a.get(i);
                        String yy=b.get(i);
                        if (xx.compareTo(yy)<0)
                            return -1;
                        else if (xx.compareTo(yy)>0)
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
      System.out.print("[");
      for (int i = 0; i < res.size(); ++i)
        {
          System.out.print("[");
          for (int j = 0; j < res.get(i).size(); j++)
             {
                if (j != res.get(i).size() - 1)
                     System.out.print(res.get(i).get(j)+", ");
                else
                     System.out.print(res.get(i).get(j));
             }
          if (i != res.size() - 1)
             System.out.println("], ");
          else
             System.out.print("]");
        }
       System.out.println("]");
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] parent, rank;
    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        // code here
        
        int n = accounts.size();
        
        parent = new int[n];
        rank = new int[n];
        
        for(int ind=0; ind<n; ind++)
            parent[ind] = ind;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int ind=0; ind<n; ind++){
            for(int inx=1; inx<accounts.get(ind).size(); inx++){
                String st = accounts.get(ind).get(inx);
                
                if(map.containsKey(st)){
                    union(ind, map.get(st));
                }
                else{
                    map.put(st, ind);
                }
            }
        }
        
        Map<Integer, List<String>> sec_map = new HashMap<>();
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            int ultimate_par = findPar(entry.getValue());
            
            List<String> al;
            if(sec_map.containsKey(ultimate_par)){
                al = sec_map.get(ultimate_par);
                
                al.add(entry.getKey());
            }
            
            else{
                al = new ArrayList<>();
                
                al.add(entry.getKey());
            }
            
            sec_map.put(ultimate_par, al);
        }
        
        for(Map.Entry<Integer, List<String>> entry : sec_map.entrySet()){
            Collections.sort(entry.getValue());
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        for(Map.Entry<Integer, List<String>> entry : sec_map.entrySet()){
            List<String> al = entry.getValue();
            
            al.add(0, accounts.get(entry.getKey()).get(0));
            
            ans.add(al);
        }
        
        return ans;
    }
    
    static void union(int a, int b){
        int par_a = findPar(a);
        int par_b = findPar(b);
        
        if(rank[par_a] < rank[par_b])
            parent[par_a] = par_b;
            
        else if(rank[par_a] > rank[par_b])
            parent[par_b] = par_a;
            
        else{
            parent[par_a] = par_b;
            rank[par_b]++;
        }    
    }
    
    static public int findPar(int ind){
        if(parent[ind] == ind)
            return ind;
        
        return parent[ind] = findPar(parent[ind]);    
    }
}
     