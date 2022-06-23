// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        
        Arrays.sort(arr,new itemcomparator());
        
        double ans = 0.0;
        int currweight = W;
        
        for(Item i : arr){
            if(i.weight <= currweight){
                ans += i.value;
                currweight -= i.weight;
            }
            else{
                ans += currweight*((double)i.value/(double)i.weight);
                break;
            }
        }
        
        return ans;
    }
}

class itemcomparator implements Comparator<Item>{
    public int compare(Item o1, Item o2){
        if(((double)o1.value/(double)o1.weight) < ((double)o2.value/(double)o2.weight)) return 1;
        else if(((double)o1.value/(double)o1.weight) > ((double)o2.value/(double)o2.weight)) return -1;
        else return 0;
    }
}