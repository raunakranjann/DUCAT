class Insert_beg {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    void addAtstart(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Node temp = head;
            head = newNode;
            head.next = temp;
        }
    }

    void disp(){
            Node current = head;
            if(head==null){
                System.out.println("List is empty");
                return;
            }
             System.out.println("Adding nodes to start of the list");
            while (current!=null) {
                System.out.println(current.data+" ");
                current= current.next;

            }
            System.out.println();
        }

        public static void main(String[] args) {
            Insert_beg sList = new Insert_beg();
            //Adding 1 node 
            sList.addAtstart(20);
            sList.disp();

            //Adding 2nd node 
            sList.addAtstart(10);
            sList.disp();
        }
}