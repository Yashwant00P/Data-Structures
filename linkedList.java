// import java.util.LinkedList;

public class linkedList {

    Node head; // creating a head node.
    private int size;

    linkedList() {
        size = 0;
    } // constructor

    // defining nodes as a class
    public class Node { // it's a nested class (geeksforgeeks.org/nested-classes-java/)
        String data; // that is defined under the
        Node next; // scope of outer class linkedList

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // To add a node in front of a linkedList.
    public void addFirst(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // To add a node in last of a linkedList.
    public void addLast(String data) {
        Node newNode = new Node(data);

        if (head == null) { // if the list is empty.
            head = newNode;
            return;
        }

        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    // To add a node at any index
    public void addIndex(String data, int index){
        if(head == null|| (head.next == null && index>1 )){
            return;
        } // Corner cases

        Node newNode = new Node(data);
        Node currNode = head;
        int count =0;
        while(currNode != null){
            if(count == index-1){
                newNode.next = currNode.next;
                currNode.next = newNode;
                return;
            }
            currNode = currNode.next;
            count++;
        }

        assert(false);
        System.out.println("Invalid Index");
    }

    // To delete the first node of the linkedList.
    public void deleteFirst() {
        if (head == null) { // if the list is empty.
            System.out.println("Empty List, nothing to delete.");
            return;
        }
        /*
         * if(head.next == null){ // if the list contains only one node.
         * head = null;
         * return;
         * }
         */
        head = this.head.next;
        size--;
    }

    // To delete the last node of the list.
    public void deleteLast() {
        if (head == null) { // if the list is empty.
            System.out.println("Empty List, nothing to delete.");
            return;
        }
        if (head.next == null) { // if the list contains only one node.
            head = null;
            return;
        }

        Node currNode = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            currNode = currNode.next;
            lastNode = lastNode.next;
        }
        currNode.next = null;
        size--;
    }

    // To set the nth node of a Linked List.
    public void setNode(String data, int index) {
        if(head == null|| (head.next == null && index>1 )){
            return;
        } // Corner cases

        Node currNode = head;
        int count =0;
        while(currNode != null){
            if(count == index){
                currNode.data = data;
                return;
            }
            currNode = currNode.next;
            count++;
        }
        assert(false);
        System.out.println("Invalid Index");
    }

    // To delete the nth node of a Linked List.
    public void deleteNode(int index) {
        if(head == null|| (head.next == null && index>1 )){
            return;
        } // Corner cases

        Node currNode = head;
        int count =0;
        while(currNode != null){
            if(count == index-1){
                currNode.next = currNode.next.next;
                size--;
                return;
            }
            currNode = currNode.next;
            count++;
        }

        assert(false);
        System.out.println("Invalid Index");
    }

    // To set the nth node from last of a Linked List.
    public void setNodeLast(String data, int nLast) {
        int index = size - nLast ; // n from start
        if (head == null || head.next == null) {
            return;
        } // corener cases

        Node nthNode = head;
        int count = 0;
        while (nthNode != null) {
            if (count == index ) {
                nthNode.data = data;
                return;
            }
            nthNode = nthNode.next;
            count++;
        }
        assert(false);
        System.out.println("Invalid index");
    }

    // To delete the nth node from last of a Linked List.
    public void deleteNodeLast(int nLast) {
        int index = size - nLast; // n from start

        if(head == null|| (head.next == null && index>1 )){
            return;
        } // Corner cases

        Node currNode = head;
        int count =0;
        while(currNode != null){
            if(count == index-1){
                currNode.next = currNode.next.next;
                size--;
                return;
            }
            currNode = currNode.next;
            count++;
        }
        assert(false);
        System.out.println("Invalid Index");
    }

    // To reverse a Linked List (Iterative method).
    public void reverseListIterate() {
        if (head == null || head.next == null) {
            return;
        } // corener cases

        Node prevNode = head;
        Node currNode = head.next;
        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            // update
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    // To reverse a Linked List (recursive method).
    public Node reverseListRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        } // ?

        Node newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    // To print the list.
    public void printList() {
        if (head == null) { // if the list is empty.
            System.out.println("Empty List, nothing to delete.");
            return;
        }

        Node currNode = head;

        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    // To get size of a list.
    public int Size() { 
        return size;
    }
    
    public static void main(String args[]) {
        linkedList list = new linkedList();
        
        list.addFirst("this");
        list.printList();
        System.out.println(list.size);

        list.addLast("is");
        list.addLast("a");
        list.addLast("list");
        list.printList();
        System.out.println("size : " +list.size);

        list.addIndex("linked", 3);
        list.printList();
        System.out.println("size : " +list.size);

        // list.setNode("This", 0);
        // list.printList();

        // list.deleteNode(3);
        // list.printList();
        // System.out.println("size : " +list.size);

        list.setNodeLast("This", 5);
        list.printList();

        list.deleteNodeLast(2);
        list.printList();
        System.out.println(list.size);

        list.reverseListIterate();
        list.printList();
        list.head = list.reverseListRecursive(list.head);
        list.printList();

    }
}