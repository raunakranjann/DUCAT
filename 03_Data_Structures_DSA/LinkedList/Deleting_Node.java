class Delete_Node {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    void addAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;

        } else {
            tail.next = newNode;
            tail = newNode;
        }

    }


    void deleteAtEnd(){

        if (head==null) {
            System.out.println("List is Empty");
        }else if (head.next==null) {
            head = null;
            tail = null;
            
        }else{

            Node temp = head;
            while (temp.next.next!=null) {
                temp = temp.next;
                if (temp.next.next==null) {
                    temp.next=null;
                }
            }
             
            
        }
    }


    void disp() {
        Node current = head;
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        System.out.println("Adding Node to the End of the list");
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println();

    }

    public static void main(String arg[]) {
        Delete_Node slist = new Delete_Node();

        // Add 1 node
        slist.addAtEnd(10);
        slist.disp();

        // Add 2 node
        slist.addAtEnd(20);
        slist.disp();


        slist.deleteAtEnd();
        slist.disp();
    }

}