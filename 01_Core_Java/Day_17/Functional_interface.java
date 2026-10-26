@FunctionalInterface 
interface My{
void show();
}

class child implements My{
    public void show(){
        System.out.println("Child show call");
    }
    public static void main(String arg[]){
        child c = new child();
        c.show();
    }
}