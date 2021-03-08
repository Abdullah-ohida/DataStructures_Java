package Linear.linked_list.generic_dataType.singlyLinkedList;

import Linear.linked_list.generic_dataType.Linkable;

public class LinkedList<T> extends Linkable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    String message = "Linked list is empty";

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertAtBeginning(T data) {
        head = new Node<>(data, head);
        if(isEmpty()){
            tail = head;
        }
            size++;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public T getHead() {
        if(isEmpty()) throw new LinkedListUnderFlowException(message);
        return head.getData();
    }

    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data, null);
        if(isEmpty()){
            head = newNode;
        }else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    public T getTail() {
        if(isEmpty()) throw new LinkedListUnderFlowException(message);
        return tail.getData();
    }

    public T removeFirst() {
        T deletedItem;
        if(isEmpty()) throw new LinkedListUnderFlowException(message);
        deletedItem = head.getData();
        head = head.getNext();
        size--;
        if(size == 0){
            tail = null;
        }
        return deletedItem;
    }

}
