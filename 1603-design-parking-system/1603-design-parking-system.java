class ParkingSystem {
    int b, m, s, b_max, m_max, s_max;
    
    public ParkingSystem(int big, int medium, int small) {
        b=0;
        m=0;
        s=0;
        
        b_max = big;
        m_max = medium;
        s_max = small;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1){
            if(b == b_max){
                return false;
            }
            
            b++;
            return true;
        }
        else if(carType == 2){
            if(m == m_max){
                return false;
            }
            
            m++;
            return true;
        }
        else{
            if(s == s_max){
                return false;
            }
            
            s++;
            return true;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */