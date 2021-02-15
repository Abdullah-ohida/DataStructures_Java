package Linear.Stack;

public class Stack {
    private int[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 1;

    public Stack(){
        this(DEFAULT_CAPACITY);
    }

    public Stack(int capacity) {
        this.elements = new int[capacity];
    }

    public void push(int value) {
        if(size >= elements.length){
            resizeStack();
        }
        elements[size++] = value;
    }

    private void resizeStack() {
        int[] temp = new int[elements.length * 2];
        System.arraycopy(elements, 0, temp, 0, elements.length);
        elements = temp;
    }

    public int getSize() {
        return size;
    }

    public int top(){
        int lastIndex = getSize() - 1;
        return elements[lastIndex];
    }
    public void pop() {
        if (elements.length - 1 >= 0) System.arraycopy(elements, 1, elements, 0, elements.length - 1);
        size--;
    }

    public void pop(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Index not fund");
        }
        if (elements.length - 1 - index >= 0)
            System.arraycopy(elements, index + 1, elements, index, elements.length - 1 - index);
        size--;
    }

   public boolean isEmpty(){
        return size == 0;
   }


    public int[] getStack() {
        return elements;
    }
}
