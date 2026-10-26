interface my{
    void show();
}
class child implements my{
    public void show(){
        System.out.println("Child show call");
    }
    public static void main(String[] args) {
        child c = new child();
        c.show();
    }
}