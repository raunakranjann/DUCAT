interface my {
    void show();
}

interface my1 extends my {
    void disp();
}

class child implements my1 {
    public void show() {
        System.out.println("Child show call");
    }

    public void disp() {
        System.out.println("Child disp call");
    }

    public static void main(String[] args) {
        child c = new child();
        c.show();
        c.disp();
    }
}