package Linear.Queue;

public class Queue {
    private int[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 1;
    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    public Queue(int capacity) {
        this.elements = new int[capacity];
    }

    public void enqueue(int value) {
        if(size >= elements.length){
            resizeQueue();
        }
        elements[size++] = value;
    }

    private void resizeQueue() {
        int[] temp = new int[elements.length * 2];
        System.arraycopy(elements, 0, temp, 0, elements.length);
        elements = temp;
    }

    public int getSize() {
        return size;
    }

    public int front() {
        final int FIRST_INDEX = 0;
        return elements[FIRST_INDEX];
    }

    public void dequeue() {
        int[] removedArr = new int[elements.length - 1];
            System.arraycopy(elements, 1, removedArr, 0, elements.length - 1);
            elements = removedArr;
        size--;
    }

    public void dequeue(int index) {
        if(index < 0 || index >= elements.length){
            throw  new IllegalArgumentException("Index not fund");
        }
        int[] removedArr = new int[elements.length - 1];
        System.arraycopy(elements, 1, removedArr, 0, elements.length - 1 - index);
        elements = removedArr;
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
