import java.util.ArrayList;

public class stackAL {

    // Creating stack as a class object.
    static class Stack{
        ArrayList<Integer> list = new ArrayList<>();

        // to check if stack is empty or not
        public boolean isEmpty(){
            return list.size() == 0;
        }

        // PUSH
        public void push(int data){
            list.add(data);
        }

        // POP
        public int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.remove(list.size()-1);
            return top;
        }

        // PEEK
        public int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }
    public static void main(String args[]) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while(!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
