class base{
 void show(){ // default
        System.out.println("base show call");
    }
}
class child extends base{
    public void show(){ //public 
        System.out.println("Child show call");
    
    }
    public static void main(String[] args) {
        child c = new child();
        c.show();
    }
} // must be base weaker and child stronger ... Order --> (Stronger) public --> protected --> default --> private (weaker)