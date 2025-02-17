public class DoublyLinkedList {
    Node head;
    Node tail;
    int size;

    public class Node {
        int data;
        Node next;
        Node prev;

        Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    //method to addFirst
    public void addFirst(int data) {
        Node newNode = new Node(data, null, null);

        if (size == 0) {
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
        }
        head = newNode;
        size++;

    }

    //method to addLast
    public void addLast(int data) {
        Node newNode = new Node(data, null, null);
        if(size == 0) {
            //same as addFirst
            head = newNode;
            
        }else{
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    //method to removeFirst
    public int removeFirst() {
        if(size == 0) {
            System.out.println("Empty List. Cannot remove first element.");
            return -1;
        }
        int removedItem = head.data;
        if (size == 1) {
            head = null;
            tail = null;
        }else{
            head = head.next;
            head.prev = null;
        }
        size--;
        return removedItem;
    }

    //method to removeLast
    public int removeLast() {
        if(size == 0) {
            System.out.println("Empty List. Cannot remove first element.");
            return -1;
        }
        int removedItem = tail.data;
        if (size == 1) {
            head = null;
            tail = null;
        }else{
            tail= tail.prev;
            tail.next = null;
        }
        size--;
        return removedItem;
    }

    //method to find the middle node without using size
    //using link hopping or traversal
    public int findMiddle() {
        //create two temporary pointers
        //this node pointers will be moved
        //to meet at the center point
        Node newHead = head;
        Node newTail = tail;

        if (size == 0) {
            System.out.println("Empty list. Cannot find middle item.");
            return -1;
        }
        int middleItem;
        if (size == 1 || size == 2) {
            middleItem = head.data;
            return middleItem;
        }else{
            newHead = newHead.next;
            newTail = newTail.prev;
            if (size % 2 == 0) {
                newTail = newTail.prev;
                while (newHead != newTail) {
                    newHead = newHead.next;
                    newTail = newTail.prev;
                }
            }else{
                while (newHead != newTail) {
                    newHead = newHead.next;
                    newTail = newTail.prev;
                }

            }
            
           
            
        }
        middleItem = newHead.data;
        return middleItem;



    }

    //method to find middle without using size
    //if even it should choose left to be mid
    public int findMiddle2() {
        if (head == null) {
            System.out.println("Empty list. Cannot find middle.");
            return - 1;
        }

        Node slow = head;
        Node fast = head.next; 

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        int middleItem = slow.data;

        return middleItem;

    }



    

    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ->");
            current = current.next;
        }
        System.out.println(" null");
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addFirst(10);
        doublyLinkedList.addFirst(20);
        doublyLinkedList.addFirst(30);
        
        doublyLinkedList.addLast(40);
        doublyLinkedList.addLast(50);
        doublyLinkedList.addLast(60);
        doublyLinkedList.addLast(70);

        
        
        doublyLinkedList.printList();
       

        

    //    int middleItem = doublyLinkedList.findMiddle();
            int middleItem = doublyLinkedList.findMiddle2();
       System.out.println(middleItem);
    }
}