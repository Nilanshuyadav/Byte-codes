//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        int n = s.length();
        char ch;
        
        int[] fre = new int[26];
        
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int ind=0; ind<p.length(); ind++){
            ch = p.charAt(ind);
            
            if(!map.containsKey(ch))
                map.put(ch, new ArrayList<>());
            
            fre[p.charAt(ind)-'a']++;    
        }
        
        int min=-1, ans=Integer.MAX_VALUE, al_size;
        String res = "-1";
        List<Integer> al;
        
        for(int ind=0; ind<n; ind++){
            ch = s.charAt(ind);
            
            if(fre[ch-'a']==0) continue;
            
            map.get(ch).add(ind);
            
            if(min!=-1 && ch!=s.charAt(min)) continue;
            
            min = Integer.MAX_VALUE;
            
            for(Map.Entry<Character, List<Integer>> entry : map.entrySet()){
                al = entry.getValue();
                ch = entry.getKey();
                
                al_size = al.size();
                
                if(al_size<fre[ch-'a'])
                    min = -1;
                else
                    min = Math.min(min, al.get(al_size-fre[ch-'a']));
            }
            
            if(min!=-1 && ind-min+1 < ans){
                ans = ind-min+1;
                res = s.substring(min, ind+1);
            }
        }
        
        return res;    
    }
}