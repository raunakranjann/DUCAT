interface calculator{
    static int add(int a, int b){
        return a+b;
    }
}
class child{
    public static void main(String arg[]){
        System.out.println(calculator.add(10,20));
    }
}
