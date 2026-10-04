class Employee{
    String name;
    double sal;
    void showemp(){
        System.out.println(name);
        System.out.println(sal);
    }
}

class Developer extends Employee{
    void writeCode(){
        System.out.println("Developer writes java code");
    }
}

class Tester extends Employee{
    void tester(){
        System.out.println("Tester test the Application");
    }
}

class Main{
    public static void main(String[] args) {
         Developer d = new Developer();
    d.name = "Raunak";
    d.sal = 120000;
    d.showemp();
    d.writeCode();

    Tester t = new Tester();
    t.name="Raushan";
    t.sal=80000;
    t.showemp();
    t.tester();
    }
   

}