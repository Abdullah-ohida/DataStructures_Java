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
        int[] newArr = new int[elements.length - 1];
        int lastIndex = getSize() - 1;
        for (int count = 0; count < elements.length - 1; count++){
            if(lastIndex == count){
                continue;
            }
            newArr[count] = elements[count];
        }
        elements = newArr;
        size--;
    }

    public void pop(int index){
        int[] newArr = new int[elements.length - 1];
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Index not fund");
        }
           for (int count = 0; count < elements.length - 1; count++){
               if(index == count){
                   continue;
               }
               newArr[count] = elements[count];
           }
           elements = newArr;
        size--;
    }

   public boolean isEmpty(){
        return size == 0;
   }

}
