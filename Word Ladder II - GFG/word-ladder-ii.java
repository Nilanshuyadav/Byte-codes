//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        Queue<Pair> q = new LinkedList<>();
        ArrayList<String> a = new ArrayList<>();
        a.add(startWord);
        
        q.add(new Pair(a, startWord));
        
        Set<String> set = new HashSet<>();
        for(String st : wordList)
            set.add(st);
        
        set.remove(startWord);
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        boolean found=false;
        
        
        while(!q.isEmpty()){
            int size = q.size();
            
            Set<String> toRemove = new HashSet<>();
            
            while(size-- > 0){
                Pair temp = q.remove();
                
                if(targetWord.equals(temp.word)){
                    found = true;
                    ans.add(new ArrayList<>(temp.al));
                    continue;
                }
                
                ArrayList<String> al = temp.al;
                StringBuilder word = new StringBuilder(temp.word);
                
                for(int ind=0; ind<word.length(); ind++){
                    char ch = word.charAt(ind);
                    for(char inx='a'; inx<='z'; inx++){
                        word.setCharAt(ind, inx);
                        if(set.contains(word.toString())){
                            toRemove.add(word.toString());
                            al.add(word.toString());
                            q.add(new Pair(new ArrayList<>(al), word.toString()));
                            al.remove(al.size()-1);
                        }
                    }
                    
                    word.setCharAt(ind, ch);
                }
                
            }
            
            if(found)
                break;
            
            for(String st : toRemove){
                set.remove(st);
            }
        }
        
        return ans;
    }
}

class Pair{
    ArrayList<String> al;
    String word;
    public Pair(ArrayList<String> al, String word){
        this.al = al;
        this.word = word;
    }
}