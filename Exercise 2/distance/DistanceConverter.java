package distance;

public class DistanceConverter {
    public static double convert(int option,double val){
        switch(option){
            case 1:
                return val/1000;
            case 2:
                return val*1000;
            case 3:
                return  val *1.609;
            case 4:
                return val/1.609;
            
            default:
                return -1;
        }
    }
  
    
}
