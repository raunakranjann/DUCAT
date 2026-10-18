class Node{
    int data;
    Node next;
    
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class Main{
    public static void main(String arg[])
       {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

    //connect the node
    first.next = second;
    second.next = third;
    
    //traverse the linkedlist 
    Node current = first;
    while(current!=null)
        {
    System.out.print(current.data+"->");
    current = current.next;
        }
    System.out.println("null");
    }
        }