package Linear.Stack;

 public class Stack {
    private int[] elements;
    private int size = -1;

    public Stack(int capacity) {
        this.elements = new int[capacity];
    }

     public void push(int data) {
        if(isFull()) throw new StackOverFlowException("Stack is full");
            elements[++size] = data;

     }

     public int peek() {
        if(isEmpty()) throw new StackUnderFlowException("Stack is empty");
            return elements[size];
     }

     public int pop() {
            if(isEmpty()) throw new StackUnderFlowException("Stack is empty");
             int lastElement = elements[size];
             elements[size--] = 0;
             return lastElement;

     }

     public boolean isEmpty() {
        return size == -1;
     }

     public boolean isFull() {
        return (size == (elements.length - 1));
     }

     public static class StackOverFlowException extends RuntimeException{
        public StackOverFlowException(String message){
            super(message);
        }
     }

     public static class StackUnderFlowException extends RuntimeException{
         public StackUnderFlowException(String message){
             super(message);
         }
     }
 }


