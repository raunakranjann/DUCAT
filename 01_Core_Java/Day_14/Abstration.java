
abstract class base{
    // base(){
    //     System.out.println("base def con call");
    // }

    final int x = 10; // final , static all works in abstract class 
}

class child extends base{
    // child(){
    //     System.out.println("child def con call");
    // }

    void show(){
        System.out.println(x);
    }
    public static void main(String[] args) {
        child c = new child();
        c.show();

    }
}
