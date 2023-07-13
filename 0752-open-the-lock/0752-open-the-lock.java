class Solution {
     public int openLock(String[] deadends, String target) {
        Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visitedSet = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("0000");

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (visitedSet.contains(cur)) {
                    continue;
                }
                if (deadendsSet.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return step;
                }
                visitedSet.add(cur);
                for (int j = 0; j < 4; j++) {
                    String s1 = plusOne(cur, j);
                    String s2 = minusOne(cur, j);
                    queue.offer(s1);
                    queue.offer(s2);
                }
            }
            step++;
        }
        return -1;
    }
    
    
    public String plusOne(String s, int i) {
        char[] charArray = s.toCharArray();
        if (charArray[i] == '9') {
            charArray[i] = '0';
        } else {
            charArray[i] = (char) (charArray[i] + 1);
        }
        return String.valueOf(charArray);
    }

    public String minusOne(String s, int i) {
        char[] charArray = s.toCharArray();
        if (charArray[i] == '0') {
            charArray[i] = '9';
        } else {
            charArray[i] = (char) (charArray[i] - 1);
        }
        return String.valueOf(charArray);
    }
}





// ******************************************************************************************


  // int ans;
//     public int openLock(String[] deadends, String target) {
//         Set<String> set = new HashSet<>();
//         ans=(int)1e8;
        
//         for(String st : deadends){
//             set.add(st);
//         }
        
//         solve(new StringBuilder("0000"), set, target, new HashMap<>(), 0);
        
//         return ans==(int)1e8 ? -1 : ans;
//     }
    
//     public void solve(StringBuilder sb, Set<String> set, String target, Map<String, Integer> map, int currSteps){
//         String st = sb.toString();
        
//         if(set.contains(st)){
//             return ;
//         }
        
//         if(map.containsKey(st) && map.get(st)<=currSteps){
//             return ;
//         }
        
//         if(target.equals(st)){
//             ans = Math.min(ans, currSteps);
//             return ;
//         }
        
//         map.put(st, currSteps);
        
//         char ch, pre, next;
//         int next_score, pre_score, min=(int)1e8;
//         for(int ind=0; ind<4; ind++){
//             ch = sb.charAt(ind);
            
//             next = next(ch);
//             pre = pre(ch);
            
//             sb.setCharAt(ind, next);
//             solve(sb, set, target, map, currSteps+1);
            
//             sb.setCharAt(ind, pre);
//             solve(sb, set, target, map, currSteps+1);
            
//             sb.setCharAt(ind, ch);
//         }
        
// //         map.put(st, min);
// //         return min;
//     }
    
//     public char next(char ch){
//         if(ch=='9'){
//             return '0';
//         }
        
//         return ++ch;
//     }
    
//     public char pre(char ch){
//         if(ch=='0'){
//             return '9';
//         }
        
//         return --ch;
//     }
// }