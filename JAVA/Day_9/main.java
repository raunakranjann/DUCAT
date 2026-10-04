package Archive.Day_9;
class base{
    private int x= 10;

}
class child extends base{

    // private member can be inherit but not access in child class 
    int y = 20;
    void show(){
        System.out.println(y);

       // System.out.println(x); --> private member cannot access... 
    }
}
class main{
    public static void main(String[] args) {
        child c = new child();
        c.show();

    }
}