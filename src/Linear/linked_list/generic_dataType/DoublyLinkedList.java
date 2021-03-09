package Linear.linked_list.generic_dataType;

public class DoublyLinkedList<T> extends Linkable<T>{
    private T data;
    private Node<T> head;
    private Node<T> tail;
    private int size;
    String message = "Linked list is empty";

    public DoublyLinkedList() {
        this.head = new Node<T>(null, null, null);
        this.tail = new Node<T>(null, head, null);
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T getHead() {
        if(isEmpty()) throw new LinkedListUnderFlowException(message);
        return head.getData();
    }

    @Override
    public T getTail() {
        if(isEmpty()) throw new LinkedListUnderFlowException(message);
        return tail.getData();
    }

    @Override
    public void insertAtBeginning(T data) {
        addData(data, head, head.getNext());
    }

    @Override
    public void insertAtEnd(T data) {
        addData(data, tail.getPrev(), tail);
    }

    private void addData(T data, Node<T> predecessor, Node<T> successor) {
        Node<T> newNode = new Node<>(data, predecessor, successor);
        predecessor.setNext(newNode);
        successor.getNext().setPrev(newNode);
        size++;
    }

    private Node<T> remove(Node<T> next) {
        Node<T> deletedData = next.getPrev();
        Node<T> successor = next.getNext();

        deletedData.setNext(successor);
        successor.setPrev(deletedData);
        size--;
        return deletedData;
    }

    @Override
    public T removeFirst() {
        if(isEmpty()) throw new LinkedListUnderFlowException(message);
        Node<T> deletedData = remove(head.getNext());
        return deletedData.getData();
    }

    public T removeEnd() {
        if(isEmpty()) throw new LinkedListUnderFlowException(message);
        Node<T> deletedData = remove(tail.getPrev());
        return deletedData.getData();
    }
}
