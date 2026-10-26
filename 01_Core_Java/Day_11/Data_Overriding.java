class dadaji {
    int x=10;

}
class papaji extends dadaji{
    int x = 20;
    void disp(){
        System.out.println(super.x);
    }
}
class child extends papaji{
    int x = 30;
    void show(){
        System.out.println(super.x);
        System.out.println(x);
    }

    public static void main(String[] args) {
        child c = new child();
        c.disp();   
        c.show();
    }
}
