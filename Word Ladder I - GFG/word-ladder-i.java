//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
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
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        Set<String> set = new HashSet<>();
        
        for(String st : wordList)
            set.add(st);
        
        if(!set.contains(targetWord))
            return 0;
            
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(startWord, 1));
        set.remove(startWord);
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            
            if(targetWord.equals(temp.st))
                return temp.step;
            
            StringBuilder sb = new StringBuilder(temp.st);
            int step = temp.step;
            
            for(int ind=0; ind<sb.length(); ind++){
                char ch = sb.charAt(ind);
                for(int inx=0; inx<26; inx++){
                    sb.setCharAt(ind,(char)('a'+inx));
                    
                    if(set.contains(sb.toString())){
                        set.remove(sb.toString());
                        q.add(new Pair(sb.toString(), step+1));
                    }
                }
                
                sb.setCharAt(ind, ch);
            }
        }
        
        return 0;
    }
}

class Pair{
    String st;
    int step;
    public Pair(String st, int step){
        this.st = st;
        this.step = step;
    }
}