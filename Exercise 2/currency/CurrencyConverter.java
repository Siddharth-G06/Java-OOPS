package currency;

public class CurrencyConverter {
    public static double convert(int option,double val){
        switch(option){
            case 1:
                return val*86.5;
            case 2:
                return val/86.5;
            case 3:
                return  val *100.17;
            case 4:
                return val/100.17;
            case 5:
                return val * 0.59;
            case 6:
                return val/0.59;
            default:
                return -1;
        }
    }
  
            
}
