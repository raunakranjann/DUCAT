class Payment{
    void pay() // Overridden
     {
        System.out.println("Making Payment");
    }
}
class Upi extends Payment{
    void pay() //override
    {
        System.out.println("Payment made using UPI");
        super.pay();
    }
}
class Creditcard extends Payment{
    void pay(){
        System.out.println("Payment made using Credit Card");
        super.pay();
    }
}
class Main{
    public static void main(String[] args) {
        Upi u = new Upi();
        u.pay();
        Creditcard c = new Creditcard();
        c.pay();
    }
}