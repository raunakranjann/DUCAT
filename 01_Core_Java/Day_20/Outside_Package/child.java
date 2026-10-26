package p2;

import p1.*;

public class child extends base
{

public void show(){
System.out.println("This is override method in child class");
}

public void showBoth(){

super.show();
show();


}

public static void main(String arg[])
{

child c = new child();
c.showBoth();

}
}