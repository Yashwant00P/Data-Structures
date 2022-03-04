
// Queue using 2 Stacks.(Taking push with O(n))
import java.util.Stack;

public class Queue_2Stacks1 {

    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty() {
            return s1.isEmpty();
        }

        // Push - O(n)
        public void add(int data) {

            // STEP 1
            while (!s1.isEmpty()) // poping out all the elements
                s2.push(s1.pop()); // of the stack1 and pushing into the stack2.

            // STEP 2
            s1.push(data); // Pushing in our data into the stack1.

            // STEP3
            while (!s2.isEmpty()) // poping out all the elements
                s1.push(s2.pop()); // of the stack2 and pushing into the stack1.
        }

        // Pop - O(1)
        public int remove() {
            if (s1.isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            return s1.pop();
        }

        // Peek - O(1)
        public int peek() {
            if (s1.isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            return s1.peek();
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

    }

}
