package Linear.linked_list.generic_dataType;

public class CircularNode<T> extends Linkable<T> {
    private Node<T> tail;
    private int size;
    String message = "Linked list is empty";

    public CircularNode() {
        this.tail = null;
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
       if(isEmpty())throw new LinkedListUnderFlowException(message);
       return tail.getNext().getData();
    }

    @Override
    public T getTail() {
        if(isEmpty()) throw new LinkedListUnderFlowException(message);
        return tail.getData();
    }

    @Override
    public void insertAtBeginning(T data) {
        if(isEmpty()){
            tail = new Node<>(data, null);
            tail.setNext(tail);
        }else {
            Node<T> newNode = new Node<>(data, tail.getNext());
            tail.setNext(newNode);
        }
        size++;
    }

    @Override
    public void insertAtEnd(T data) {
        insertAtBeginning(data);
        tail = tail.getNext();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) throw new LinkedListUnderFlowException(message);
        Node<T> head = tail.getNext();
        if (head == tail) {
            tail = null;
        } else tail.setNext(head.getNext());
        size--;
        return head.getData();
    }

    public void rotate(){
        if(!isEmpty())
            tail = tail.getNext();
    }
}
