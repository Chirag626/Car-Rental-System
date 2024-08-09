package car_Rental_System_Project;


class Customer {
    private int Customerid;
    private String Cname;
    private long Phn_No;
    private String Address;
 
    public Customer(int var1, String var2, long var3, String var5) {
       this.Customerid = var1;
       this.Cname = var2;
       this.Phn_No = var3;
       this.Address = var5;
    }
 
    public int getCustomerId() {
       return this.Customerid;
    }
 
    public String getCName() {
       return this.Cname;
    }
 
    public long getPhone() {
       return this.Phn_No;
    }
 
    public String getAddress() {
       return this.Address;
    }
 }
 