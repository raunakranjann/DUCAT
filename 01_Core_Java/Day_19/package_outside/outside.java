package p2;

import p1.*;

class outside(){

void disp(){
System.out.println("outside disp call");
}

public static void main(String arg[]){

outside o = new outside();
o.disp();
within ww = new within();
ww.show();

}
}