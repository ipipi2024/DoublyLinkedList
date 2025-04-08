public class DoublyLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    public static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    // Method to addFirst
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data, null, null);

        if (size == 0) {
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    // Method to addLast
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data, null, null);
        if (size == 0) {
            // Same as addFirst
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    // Method to removeFirst
    public T removeFirst() {
        if (size == 0) {
            System.out.println("Empty List. Cannot remove first element.");
            return null;
        }
        T removedItem = head.data;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return removedItem;
    }

    // Method to removeLast
    public T removeLast() {
        if (size == 0) {
            System.out.println("Empty List. Cannot remove last element.");
            return null;
        }
        T removedItem = tail.data;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return removedItem;
    }

    // Method to find the middle node without using size
    // Using link hopping or traversal
    public T findMiddle() {
        // Create two temporary pointers
        // These node pointers will be moved
        // to meet at the center point
        Node<T> newHead = head;
        Node<T> newTail = tail;

        if (size == 0) {
            System.out.println("Empty list. Cannot find middle item.");
            return null;
        }
        
        T middleItem;
        if (size == 1 || size == 2) {
            middleItem = head.data;
            return middleItem;
        } else {
            newHead = newHead.next;
            newTail = newTail.prev;
            if (size % 2 == 0) {
                newTail = newTail.prev;
                while (newHead != newTail) {
                    newHead = newHead.next;
                    newTail = newTail.prev;
                }
            } else {
                while (newHead != newTail) {
                    newHead = newHead.next;
                    newTail = newTail.prev;
                }
            }
        }
        middleItem = newHead.data;
        return middleItem;
    }

    // Method to find middle without using size
    // If even it should choose left to be mid
    public T findMiddle2() {
        if (head == null) {
            System.out.println("Empty list. Cannot find middle.");
            return null;
        }

        Node<T> slow = head;
        Node<T> fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        T middleItem = slow.data;

        return middleItem;
    }

    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ->");
            current = current.next;
        }
        System.out.println(" null");
    }

    public static void main(String[] args) {
        // Example with Integer
        DoublyLinkedList<Integer> intList = new DoublyLinkedList<>();
        intList.addFirst(10);
        intList.addFirst(20);
        intList.addFirst(30);
        
        intList.addLast(40);
        intList.addLast(50);
        intList.addLast(60);
        intList.addLast(70);
        
        System.out.println("Integer list:");
        intList.printList();
        
        Integer middleItem = intList.findMiddle2();
        System.out.println("Middle item: " + middleItem);
        
        // Example with String
        DoublyLinkedList<String> stringList = new DoublyLinkedList<>();
        stringList.addFirst("Apple");
        stringList.addFirst("Banana");
        stringList.addFirst("Cherry");
        
        stringList.addLast("Date");
        stringList.addLast("Elderberry");
        
        System.out.println("\nString list:");
        stringList.printList();
        
        String middleString = stringList.findMiddle2();
        System.out.println("Middle item: " + middleString);
    }
}