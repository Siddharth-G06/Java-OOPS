package employee;

public class AssociateProfessor extends employee {
    protected double bPay;
    protected String des;

    public AssociateProfessor(String emp_name, String emp_id, String address, String mail_id, String mobile_no,
                              double bPay, String des) {
        super(emp_name, emp_id, address, mail_id, mobile_no);
        this.bPay = bPay;
        this.des = des;
    }

    @Override
    public void paySlip() {
        double hra = 0.97 * bPay;
        double da = 0.10 * bPay;
        double pf = 0.12 * bPay;
        double staff_club = 0.001 * bPay;
        double gross = bPay + hra + da;
        double net = gross - (pf + staff_club);

        System.out.println("\nPaySlip for Associate Professor: " + emp_name);
        display();
        System.out.println("Designation: " + des);
        System.out.println("Basic Pay: " + bPay);
        System.out.println("Gross Salary: " + gross);
        System.out.println("Net Salary: " + net);
    }
}
