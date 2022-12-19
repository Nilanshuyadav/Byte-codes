class Solution {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.count!=b.count?a.count-b.count: a.ind-b.ind);
        
        for(int ind : arr)
            pq.add(new Pair(ind, count_one(ind)));
        
        for(int ind=0; ind<arr.length; ind++)
            arr[ind] = pq.remove().ind;
        
        return arr;
    }
    
    public int count_one(int x){
        int count = 0;
        
        while(0<x){
            if((x&1) == 1)
                count++;
            x = x>>1;
        }
        
        return count;
    }
}

class Pair{
    int ind;
    int count;
    
    public Pair(int ind, int count){
        this.ind = ind;
        this.count = count;
    }
}