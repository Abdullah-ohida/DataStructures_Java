package Linear.Queue;

import Linear.Stack.Stack;

import java.util.Arrays;

public class Queue {
    private int[] elements;
    private int size = -1;

    public Queue(int capacity) {
        elements = new int[capacity];
    }

    public void enqueue(int value) {
        if(isFull()) throw new Stack.StackOverFlowException("Queue is full");
        elements[++size] = value;
    }

    public int front() {
        if(isEmpty()) throw new Stack.StackUnderFlowException("Queue is empty");
        final int FIRST_INDEX = 0;
        return elements[FIRST_INDEX];
    }


    public int dequeue() {
        if(isEmpty()) throw new Stack.StackUnderFlowException("Queue is empty");
        int firstIndex = 0;
        int firstElement = 0;
        for(int count = 0; count < elements.length; count++){
            if(elements[0] == 0){
                firstIndex++;
            }else {
                firstElement = elements[firstIndex];
                elements[firstIndex] = 0;
                size--;
                break;
            }
        }
        return firstElement;
    }

    public boolean isEmpty() {
        return size == -1;
    }

    public boolean isFull(){
        return size == (elements.length - 1);
    }

    public int getQueueLength(){
        return size;
    }

    public int[] getElement(){
        return elements;
    }
}
