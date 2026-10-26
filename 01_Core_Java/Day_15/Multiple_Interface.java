interface my{
    void show();
}
interface my1{
    void disp();
}
class child1 implements my,my1{
    public void show(){
        System.out.println("Child1 show call");
    }
    public void disp(){
        System.out.println("Child1 disp call");
    }
}
class Main{
    public static void main(String[] args) {
        child1 c = new child1();
        c.show();
        c.disp();
    }
}