// Queue using LinkedList.
public class Queue_LL {

    // LinkedList
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // Queue
    static class Queue {

        static Node head = null;
        static Node tail = null;

        public boolean isEmpty() {
            return head == null && tail == null;
        }

        // enqueue O(1)
        public void add(int data) {
            Node newNode = new Node(data);

            // 1st element add
            if (tail == null) {
                tail = head = newNode;
            }
            tail.next = newNode;
            tail = newNode;
        }

        // dequeue - O(n).
        public int remove() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            int front = head.data;

            // single element condition
            if (head == tail) {
                tail = null;
            }

            head = head.next;
            return front;
        }

        // Peek - O(n)
        public int peek() {
            return head.data;
        }

        // To reverse a queue.
        public void reverse() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return;
            }

            // STEP 1 - pop out of queue
            int temp = remove(); // and temporarily store.

            // STEP - reverse the remaining queue.
            reverse();

            // STEP 3 - Push in the removed element.
            add(temp);
        }

        // TO add at the front of the queue. - O(1)
        public void addFront(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;            
        }
    }

}
