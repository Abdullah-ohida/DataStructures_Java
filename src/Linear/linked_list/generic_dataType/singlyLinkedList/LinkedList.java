package Linear.linked_list.generic_dataType.singlyLinkedList;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertAtBeginning(T data) {
        head = new Node<>(data, head);
        if(size == 0){
            tail = head;
        }
            size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T getHead() {
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
        return tail.getData();
    }

    public T removeFirst() {
        T deletedItem;
        if(isEmpty()) throw new LinkedListUnderFlowException("List is empty");
        deletedItem = head.getData();
        head = head.getNext();
        size--;
        if(size == 0){
            tail = null;
        }
        return deletedItem;
    }

    public static class LinkedListUnderFlowException extends RuntimeException{
        public LinkedListUnderFlowException(String message) {
            super(message);
        }
    }
}
