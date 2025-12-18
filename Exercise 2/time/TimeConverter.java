package time;

public class TimeConverter {
    public static double convert(int option,double val){
        switch(option){
            case 1:
                return val*60;
            case 2:
                return val/60;
            case 3:
                return  val *3600;
            case 4:
                return val/3600;
            
            default:
                return -1;
        }
    }
}
