class Solution{       
    private List<String> ans;
    private int l;
    public List<String> restoreIpAddresses(String s) {
       ans = new ArrayList<>();
       l = s.length();
       f(s, 0, "", 0);
       return ans;
   }
   
   private boolean dfs(String ip){
       if(ip.length() > 3 || ip.length() == 0) return false;
       if(ip.length() > 1 && ip.charAt(0) == '0') return false;
       if(ip.length() > 0 && Integer.parseInt(ip) > 255) return false;
       return true; 
   }

   private void f(String s, int index, String ip, int dot){
       if(dot == 3){
           if(dfs(s.substring(index))) {
               ip += s.substring(index);
               ans.add(ip);
           }
           return;
       }
       
       for(int i = index; i < l; i++){
           if(dfs(s.substring(index, i +1))){
               int k = s.substring(index, i+1).length();
               ip += s.substring(index, i+1) + ".";
               f(s, i+1, ip, dot+1);
               ip = ip.substring(0, ip.length() - k -1);
           }
       }
   }
}