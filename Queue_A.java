//implementing Que using array.
public class Queue_A {

    static class Queue {
        static int arr[];
        static int size;
        static int rear = -1;

        Queue(int size) {
            arr = new int[size];
            Queue.size = size;
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        public boolean isFull(){
            return rear == size;
        }
        
        // enqueue O(1)
        public void add(int data) {
            if (rear == size - 1) {
                System.out.println("full queue");
                return;
            }

            rear++;
            arr[rear] = data;
        }

        // dequeue - O(n).
        public int remove() {
            if (rear == -1) {
                System.out.println("empty queue");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        // Peek - O(1)
        public int peek() {
            if (rear == -1) {
                System.out.println("empty queue");
                return -1;
            }
            return arr[0];
        }

        // To reverse a queue. - O(n)
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

    }

}
