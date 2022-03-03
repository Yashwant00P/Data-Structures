// Stack using ArrayList as object
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
        
        // To Push at Bottom of the Stack
        public void pushBottom(int data){
            if(isEmpty()){
                list.add(data);
                return;
            }
            
            list.add(0, data);
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
}
