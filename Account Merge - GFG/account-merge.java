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
            List<String> al = accounts.get(ind);
            
            for(int j=1; j<al.size(); j++){
                if(map.containsKey(accounts.get(ind).get(j))){
                    int from_par = findPar(map.get(accounts.get(ind).get(j)));
                    int to_par = findPar(ind);
                    
                    if(from_par != to_par){
                        union(from_par, to_par);
                    }
                }
                
                map.put(accounts.get(ind).get(j), ind);
            }
        }
        
        Map<Integer, Set<String>> map2 = new HashMap<>();
        
        for(int ind=0; ind<n; ind++){
            if(findPar(ind) == ind)
                map2.put(ind, new TreeSet<>());
        }
        
        for(int ind=0; ind<n; ind++){
            int par = parent[ind];
            
            Set<String> s = map2.get(par);
            
            for(int inx=1; inx<accounts.get(ind).size(); inx++)
                s.add(accounts.get(ind).get(inx));
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        for(Map.Entry<Integer, Set<String>> entry : map2.entrySet()){
            Set<String> set = entry.getValue();
            
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(entry.getKey()).get(0));
            
            for(String st : set)
                temp.add(st);
            ans.add(temp);    
        }
        
        return ans;
    }
    
    static public void union(int from_par, int to_par){
        if(rank[from_par] < rank[to_par])
            parent[from_par] = to_par;
        else if(rank[from_par] > rank[to_par])
            parent[to_par] = from_par;
        else{
            parent[from_par] = to_par;
            rank[to_par]++;
        }    
    }
    
    public static int findPar(int ind){
        if(parent[ind] == ind)
            return ind;
            
        return parent[ind] = findPar(parent[ind]);
    }
}
     