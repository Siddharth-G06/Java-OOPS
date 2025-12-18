package employee;

public class employee {
    public String emp_name;
    String emp_ID;
    String address;
    String mail_ID;
    String mobile_no;

    public employee(String emp_name,String emp_ID,String address,String mail_ID,String mobile_no){
        this.emp_name = emp_name;
        this.emp_ID = emp_ID;
        this.address = address;
        this.mail_ID = mail_ID;
        this.mobile_no = mobile_no;
    }


    public void display(){
        System.out.println("--------------------------------------------------");
        System.out.println("Employee ID      : " + emp_ID);
        System.out.println("Name             : " + emp_name);
        System.out.println("Address          : " + address);
        System.out.println("Email            : " + mail_ID);
        System.out.println("Mobile No        : " + mobile_no);
        System.out.println("--------------------------------------------------");
    }
    public void paySlip() {
        System.out.println("Basic Employee - no payslip");
    }
}
