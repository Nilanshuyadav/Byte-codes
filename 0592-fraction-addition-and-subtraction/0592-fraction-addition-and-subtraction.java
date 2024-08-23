class Solution {
    public String fractionAddition(String ex) {
        int n = ex.length();
        StringBuilder sb = new StringBuilder("");
        int pro = 1;
        
        for(int i=0; i<n; i++){
            if(ex.charAt(i) == '/'){
                i++;
                sb.append('/');
                
                while(i<n && '0'<=ex.charAt(i) && ex.charAt(i)<='9'){
                    sb.append(ex.charAt(i));
                    i++;
                }
                
                if(i==n) break;
                
                sb.append(',');
                sb.append(ex.charAt(i));
            }
            else{
                sb.append(ex.charAt(i));
            }
        }
        
        String[] arr = sb.toString().split(",");
        
        for(String st : arr){
            pro *= (Integer.parseInt(st.substring(st.indexOf('/')+1)));
        }
        
        
        int num_n, num_d, temp, sum=0;
        
        for(String st : arr){
            if(st.charAt(0)=='+' || st.charAt(0)=='-'){
                num_n = Integer.parseInt(st.substring(1, st.indexOf("/")));
            }
            else{
                num_n = Integer.parseInt(st.substring(0, st.indexOf("/")));
            }
            
            num_d = Integer.parseInt(st.substring(st.indexOf("/")+1));
            
            temp = num_n * (pro/num_d);
            
            if(st.charAt(0)=='-'){
                sum -= temp;
            }
            else{
                sum += temp;
            }
        }
        
        int hcf=1;
        
        for (int i = 1; i <= sum || i <= pro; i++)
        {
         if (sum % i == 0 && pro % i == 0)
            hcf = i;
        }
        
        sum /= hcf;
        pro /= hcf;
        
        String ans = "" + sum + "/";
        
        if(sum==0){
            ans += "1";
        }
        else{
            ans += pro;
        }
        
        return ans;
    }
    
    public int GCD(int x, int y){
        if (x == 0) 
            return y; 
        if (y == 0) 
            return x; 
  
        
        if (x == y) 
            return x; 
  
       
        if (x > y) 
            return GCD(x - y, y); 
        return GCD(x, y - x); 
    }
}

