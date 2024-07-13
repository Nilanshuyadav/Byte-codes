class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        robot temp, arr[] = new robot[n];
        
        for(int i=0; i<n; i++){
            arr[i] = new robot(positions[i], healths[i], directions.charAt(i));    
        }
        
        Arrays.sort(arr, (a,b) -> a.pos-b.pos);
        
        List<int[]> ans = new ArrayList<>();
        
        Stack<int[]> st = new Stack<>();
        
        for(int i=0; i<n; i++){
            temp = arr[i];
            
            if(temp.dir == 'R'){
                st.push(new int[]{temp.pos, temp.hea});
            }
            else{
                if(st.isEmpty()){
                    ans.add(new int[]{temp.pos, temp.hea});
                    continue;
                }
                else{
                    if(st.peek()[1] == temp.hea){
                        st.pop();
                    }
                    else if(st.peek()[1] > temp.hea){
                        st.push(new int[]{ st.peek()[0], st.pop()[1]-1});
                    }
                    else{
                        while(!st.isEmpty()){
                            if(st.peek()[1] == temp.hea){
                                temp.hea = 0;
                                st.pop();
                                break;
                            }
                            else if(st.peek()[1] > temp.hea){
                                st.push(new int[]{st.peek()[0], st.pop()[1]-1});
                                break;
                            }       
                            else{
                                st.pop();
                                temp.hea--;
                            }
                        }
                        
                        if(st.isEmpty() && temp.hea>0){
                            ans.add(new int[]{temp.pos, temp.hea});
                        }
                    }
                }
            }
        }
        
        while(!st.isEmpty()){
            ans.add(new int[]{st.peek()[0], st.pop()[1]});
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> al = new ArrayList<>();
        
        for(int[] i : ans){
            map.put(i[0], i[1]);
        }
        
        for(int i : positions){
            if(map.containsKey(i))
                al.add(map.get(i));
        }
        
        return al;
    }
}

class robot{
    int pos, hea;
    char dir;
    
    public robot(int pos, int hea, char dir){
        this.pos = pos;
        this.hea = hea;
        this.dir = dir;
    }
}