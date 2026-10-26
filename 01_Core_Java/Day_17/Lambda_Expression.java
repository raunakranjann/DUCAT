@FunctionalInterface 
interface my{
    void show();
    default void disp(){
        System.out.println("My disp");
    }
}
class child{
    public static void main(String arg[]){
        my obj=()->{
            System.out.println("Hello Java");
        };
        obj.show();
        obj.disp();
    }
}