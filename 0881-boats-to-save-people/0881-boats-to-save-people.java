class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n =people.length;
        
        Arrays.sort(people);
        
        int boat=0;
        int i = 0;
        int j = n-1;
        
        while(i<j){
            if(people[i] + people[j] <= limit) {
                boat++;
                i++;
                j--;
            }
            else if(people[i] + people[j] > limit){
                boat++;
                j--;
            }
        }
        if(i==j) return ++boat;
        return boat;
    }
}