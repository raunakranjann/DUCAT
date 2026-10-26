class Employee{
    String name;
    double salary;
    void login(){
        System.out.println(name+" Logged In");
    }
}
class Developer extends Employee{
    void writeCode()
    {
        System.out.println(name+ "is writing java code");
       
    }
}

class Main{
    public static void main(String arg[]) {
        Developer d = new Developer();
        d.name = "Sachin";
        d.salary = 5000;
        d.login();
        d.writeCode();
         System.out.println(d.name + "'s salary is "+ d.salary);
    }
}