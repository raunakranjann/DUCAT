abstract class Atm {
    abstract void withdraw(int amount);
    void welcome(){
        System.out.println("Welcome to ATM");
    }
}
class SbiAtm extends Atm{

    private int balance= 10000;

    //provide implementation

    void withdraw(int amount)
    {
        if(amount<=balance){
            balance = balance-amount;
            System.out.println("Please Collect yout cash :₹ "+amount);
            System.out.println("Remaining Balace : ₹ "+ balance);
        }else{
            System.out.println("Insufficient Balance");
        }
    }

    public static void main(String[] args) {
        Atm atm = new SbiAtm();
        atm.welcome();
        atm.withdraw(3000);
    }
}