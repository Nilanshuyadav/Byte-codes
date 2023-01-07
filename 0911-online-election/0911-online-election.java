class TopVotedCandidate {
    
    Map<Integer, Integer> map;
    int[] time;
    int n;
    
    public TopVotedCandidate(int[] persons, int[] times) {
        map = new TreeMap<>();
        time = times;
        n = persons.length;
        int[] votes = new int[n];
        int max = 0;
        
        map.put(0,0);
        
        for(int ind=0; ind<n; ind++){
            votes[persons[ind]]++;
            if(votes[max]<votes[persons[ind]])
                max = persons[ind];
            else if(votes[max] == votes[persons[ind]])
                max = persons[ind];
            
            map.put(times[ind], max);
        }
    }
    
    public int q(int t) {
        int index = solve(time, t);
        
        if(index!=n && time[index] == t)
            return map.get(t);
        else if(index==0)
            return map.get(0);
        else
            return map.get(time[index-1]);
    }
    
    public int solve(int array[], int key)
    {
        int low = 0, high = array.length;
        int mid;
 
        // Till high does not crosses low
        while (low < high) {
 
            // Find the index of the middle element
            mid = low + (high - low) / 2;
 
            // If key is less than or equal
            // to array[mid], then find in
            // left subarray
            if (key <= array[mid]) {
                high = mid;
            }
 
            // If key is greater than array[mid],
            // then find in right subarray
            else {
 
                low = mid + 1;
            }
        }
 
        // If key is greater than last element which is
        // array[n-1] then lower bound
        // does not exists in the array
        if (low < array.length && array[low] < key) {
            low++;
        }
 
        // Returning the lower_bound index
        return low;
    }
}
/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */