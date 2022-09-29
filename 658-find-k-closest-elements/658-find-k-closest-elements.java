class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new The_Comparator());
        
        for(int ind=0; ind<arr.length; ind++){
            pq.add(new Pair(ind,Math.abs(arr[ind]-x)));
        }
        
        List<Integer> ans = new ArrayList<>();
        
        while(k-->0){
            Pair temp = pq.remove();
            ans.add(arr[temp.ind]);
        }
        
        Collections.sort(ans);
        return ans;
    }
}
                                                     
class The_Comparator implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        if(p1.val != p2.val) return p1.val-p2.val;
        else return p1.ind-p2.ind;
    }
}

class Pair{
    int ind;
    int val;
    public Pair(int ind, int val){
        this.ind = ind;
        this.val = val;
    }
}