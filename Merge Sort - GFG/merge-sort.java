//{ Driver Code Starts
import java.util.*;

class Merge_Sort
{
    //method to print the elements of the array
	static void printArray(int arr[])
    {
        StringBuffer sb=new StringBuffer("");
        int n = arr.length;
        for (int i=0; i<n; ++i)
            sb.append(arr[i]+" ");
        System.out.println(sb.toString());
    }

    

	public static void main(String args[])
	{
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking testcases
		int T = sc.nextInt();
		while(T>0)
		{
		    //taking elements count
			int n = sc.nextInt();
			
			//creating an object of class Merge_Sort
			Merge_Sort ms = new Merge_Sort();
			
			//creating an array of size n
			int arr[] = new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

            
			Solution g = new Solution();
			
			//calling the method mergeSort
			g.mergeSort(arr,0,arr.length-1);

            //calling the method printArray
			ms.printArray(arr);
		T--;
		}
	}
}



// } Driver Code Ends


class Solution
{
    void merge(int arr[], int l, int m, int h)
    {
         // Your code here
         int n = h-l+1;
         int[] temp = new int[n];
         
         int i=l, k=0, j=m+1;
         
         while(i<=m && j<=h){
             if(arr[i]<arr[j])
                temp[k++] = arr[i++];
             else
                temp[k++] = arr[j++];
         }
         
         while(i<=m)
            temp[k++] = arr[i++];
         while(j<=h)
            temp[k++] = arr[j++];
            
         for(int ind=0; ind<n; ind++)
            arr[l+ind] = temp[ind];
    }
    
    void mergeSort(int arr[], int l, int h)
    {
        if(l<h){
            int m = l + (h-l)/2;
            
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, h);
            merge(arr, l ,m, h);
        }
    }
}
