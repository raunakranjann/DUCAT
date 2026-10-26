interface Payment{
    void pay(double amount);
}
class GooglePay implements Payment{
    public void pay(double amount){
        System.out.println("Paid Rs: "+amount+" using Google Pay");
    }
}
class PhonePe implements Payment{
    public void pay(double amount){
        System.out.println("Paid Rs: "+amount+" using PhonePe");
    }
}

class Main{
    public static void main(String[] args) {

        Payment p = new GooglePay();
        Payment p1 = new PhonePe();
        p.pay(1000);
        p1.pay(2000);

    }
}
