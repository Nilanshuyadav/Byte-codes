//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n]; 
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
			}
		
			Solution obj = new Solution();
			obj.selectionSort(arr, n);
			
			for(int i=0;i<n;i++)
		    	System.out.print(arr[i]+" ");
		    System.out.println();
			t--;
		}
		
	}
}

// } Driver Code Ends


class Solution
{
	int  select(int arr[], int i)
	{
        // code here such that selectionSort() sorts arr[]
        int min_ind = i;
        
        for(int ind=i; ind<arr.length; ind++){
            if(arr[ind] < arr[min_ind])
                min_ind = ind;
        }
        
        return min_ind;
	}
	
	void selectionSort(int arr[], int n)
	{
	    int temp, min_ind;
	    for(int ind=0; ind<n; ind++){
	        min_ind = select(arr, ind);
	        
	        temp = arr[min_ind];
	        arr[min_ind] = arr[ind];
	        arr[ind] = temp;
	    }
	}
}