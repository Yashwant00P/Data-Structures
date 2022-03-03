public class stackLL {

    // Creating a node representing linkedList.
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // creating a new Stack.
    public static class Stack {

        public static Node top; // This is the head node of the ll
        // which is the top in stack

        public boolean isEmpty() {
            return top == null;
        }

        // PUSH
        public void push(int data) {
            Node newNode = new Node(data);
            if (top == null) {
                top = newNode;
                return;
            }

            newNode.next = top;
            top = newNode;
        }

        // POP
        public int pop(){
            if (top == null) {
                return -1;
            }
            Node temp = top;
            top = top.next;
            return temp.data;
        }

        // PEEK
        public int peek(){
        if (top == null) {
            return -1;
        }
        return top.data;
      }  
    
        // To Push at the bottom of a Stack.
        public void pushBottom(int data){
            Node newNode = new Node(data);
            if(top == null){
                top = newNode;
                return;
            }
            Node temp = top;
            while(temp.next != null){
                temp = temp.next;
                
            }
            temp.next = newNode;
        }
        
    }

    // To reverse a Stack.
    public static void reverseStack(Stack stack){
        if(stack.isEmpty()){
            return;
        }

        int temp = stack.pop();
        reverseStack(stack);
        stack.pushBottom(temp);
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.pushBottom(0);
        reverseStack(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
