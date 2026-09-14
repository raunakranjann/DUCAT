class dadaji{
    void show(){
        System.out.println("dadaji show call");

    }
}

class papaji extends dadaji{
    void disp(){
        System.out.println("papaji disp call");

    }

}

class child extends papaji {
    void print(){
        System.out.println("child show call");
    }

    public static void main(String[] args) {
        child c = new child();
        c.show();
        c.disp();
        c.print();
    }
}