class Payment{
    String paymentMode;
    float amount;
    Payment(String paymentMode, float amount)
    {
        this.paymentMode=paymentMode;
        this.amount = amount;

    }
    void makePayment()
    {
        System.out.println("Payment Mode : "+paymentMode);
        System.out.println("Amount Paid "+amount);

    }
}

class Order{
    int orderid;
    Payment payment; //Has - A - Relationship
    Order(int orderid, Payment payment)
    {
        this.orderid= orderid;
        this.payment= payment;

    }
    void showOrder(){
        System.out.println("Order ID : "+ orderid);
        payment.makePayment();
    }

    public static void main(String arg[]) {
        Payment p = new Payment("UPI", 2500);
        Order order = new Order(101, p);
        order.showOrder();

    }

}