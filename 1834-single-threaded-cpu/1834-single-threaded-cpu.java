class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new my_comparator());
        
        int n = tasks.length;
        int[][] arr = new int[n][3];
        
        for(int ind=0; ind<n; ind++){
            arr[ind][0] = tasks[ind][0];
            arr[ind][1] = tasks[ind][1];
            arr[ind][2] = ind;
        }
        
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        
        int[] ans = new int[n];
        int ind = 0, start_time, process_time, index, time = arr[0][0], k=0;
        
        while(!pq.isEmpty() || ind<n){
            while(ind<n && arr[ind][0] <= time){
                pq.add(new int[]{arr[ind][1], arr[ind][2]});
                ind++;
            }

            if(!pq.isEmpty()){
                int[] temp = pq.remove();

                time += temp[0];
                ans[k++] = temp[1];
            }
            else{
                time = arr[ind][0];
            }    
        }       
        
        return ans;
    }
}

class my_comparator implements Comparator<int[]>{
    public int compare(int[] a, int[] b){
        if(a[0] != b[0])
            return a[0]-b[0];
        
        return a[1]-b[1];
    }
}