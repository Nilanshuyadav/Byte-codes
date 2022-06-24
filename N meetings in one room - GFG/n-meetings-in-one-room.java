// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        int ans = 1;
        
        
        meet[] meeting = new meet[n];
        for(int i=0;i<n;i++){
            meeting[i] = new meet(start[i],end[i],i+1);
        }
        
        Arrays.sort(meeting,new meetcomparator());
        
        int meeting_end = meeting[0].end;
        
        for(int i = 1;i<n;i++){
            if(meeting[i].start > meeting_end) {
                ans++;
                meeting_end = meeting[i].end;
            }
        }
        
        return ans;
    }
}

class meetcomparator implements Comparator<meet>{
    public int compare(meet o1,meet o2){
        if(o1.end > o2.end) return 1;
        else if(o1.end < o2.end) return -1;
        else if(o1.id > o2.id)return 1;
        else return -1;
    }
}

class meet{
    int start;
    int end;
    int id;
    
    public meet(int start,int end,int id){
        this.start = start;
        this.end = end;
        this.id = id;
    }
}
