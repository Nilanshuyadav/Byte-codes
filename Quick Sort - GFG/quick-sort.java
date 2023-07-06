//{ Driver Code Starts
import java.util.*;
class Sorting
{
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    // Driver program
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

			
			new Solution().quickSort(arr,0,n-1);
			printArray(arr);
		    T--;
		}
} }
// } Driver Code Ends


class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        // code here
        if(low >= high){
            return;
        }
        
        int pivot = partition(arr, low, high);
        
        quickSort(arr, low, pivot-1);
        quickSort(arr, pivot+1, high);
    }
    static int partition(int arr[], int low, int high)
    {
        // your code here
        
        int pivot = low, ind=low;
        
        while(ind<=high){
            if(arr[ind]<=arr[pivot]){
                swap(arr, ind, pivot);
                pivot = ind;
                ind++;
            }
            else{
                swap(arr, ind, high);
                high--;
            }
        }
        
        return pivot;
    } 
    
    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
