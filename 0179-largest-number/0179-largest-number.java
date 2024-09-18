class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        
        List<String> al = new ArrayList<>();
        
        for(int i : nums){
            al.add(String.valueOf(i));
        }
        
        Collections.sort(al, new myComparator());
        
        StringBuilder sb = new StringBuilder("");
        
        for(String s : al){
            sb.append(s);
        }
        
        if(sb.charAt(0)=='0') return "0";
        
        return sb.toString();
    }
    
}

class myComparator implements Comparator<String>{
    public int compare(String a, String b){
//         int a_len = a.length();
//         int b_len = b.length();
//         int a_num, b_num;
        
//         for(int i=0; i<10; i++){
//             if(i<a_len && i<b_len){
//                 a_num = a.charAt(i)-'0';
//                 b_num = b.charAt(i)-'0';
                
//                 if(a_num == b_num) continue;
                
//                 return a_num<b_num ? 1 : -1;
//             }
//             else if(a_len<=i && b_len<=i) return 0;
            
//             if(a_len<=i){
//                 a_num = a.charAt(a_len-1)-'0';
//                 b_num = b.charAt(i)-'0';
                
//                 if(a_num == b_num) continue;
                
//                 return a_num<b_num ? 1 : -1;
//             }
//             else {
//                 a_num = a.charAt(i)-'0';
//                 b_num = b.charAt(b_len-1)-'0';
                
//                 if(a_num == b_num) continue;
                
//                 return a_num<b_num ? 1 : -1;
//             }
//         }
        
//         return 0;
        StringBuilder pre = new StringBuilder(""),
                post = new StringBuilder("");
        
        pre.append(a);
        pre.append(b);
        
        post.append(b);
        post.append(a);
        
        return post.compareTo(pre);
    }
}

