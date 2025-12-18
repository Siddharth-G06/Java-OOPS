import employee.employee;

public class Programmer extends employee {
   protected String des;
   protected double bPay;

   public Programmer(String var1, String var2, String var3, String var4, String var5, double var6, String var8) {
      super(var1, var2, var3, var4, var5);
      this.bPay = var6;
      this.des = var8;
   }

   public void paySlip() {
      double var1 = 0.97 * this.bPay;
      double var3 = 0.1 * this.bPay;
      double var5 = 0.12 * this.bPay;
      double var7 = 0.001 * this.bPay;
      double var9 = this.bPay + var1 + var3;
      double var11 = var9 - (var5 + var7);
      System.out.println("\nPaySlip for Programmer: " + this.emp_name);
      this.display();
      System.out.println("Designation: " + this.des);
      System.out.println("Basic Pay: " + this.bPay);
      System.out.println("Gross Salary: " + var9);
      System.out.println("Net Salary: " + var11);
   }
}
