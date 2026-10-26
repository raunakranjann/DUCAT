interface vehicle {
    void start();
    default void stop(){
        System.out.println("Vehicle stopped");
    }

}
class Car implements vehicle{
    public void start(){
        System.out.println("Car Started...");
    }
}
class Main{
public static void main(String arg[]){
    Car c = new Car();
    c.start();
    c.stop();
}

}