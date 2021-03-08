package Linear.linked_list.generic_dataType;

import Linear.linked_list.generic_dataType.singlyLinkedList.Node;

public abstract class Linkable<T> {
    public abstract int getSize();

    public abstract boolean isEmpty();

    public static class LinkedListUnderFlowException extends RuntimeException{
        public LinkedListUnderFlowException(String message) {
            super(message);
        }
    }

    public abstract T getHead();

    public abstract T getTail();

    public abstract void insertAtBeginning(T data);

    public abstract void insertAtEnd(T data);

    public abstract T removeFirst();
}
