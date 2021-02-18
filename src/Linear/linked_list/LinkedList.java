package Linear.linked_list;

import java.util.NoSuchElementException;

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void insertAtBeginning(int data) {
       Node newNode = new Node(data);
       newNode.setPointer(head);
       head = newNode;
    }

    public String printList (LinkedList list){
        StringBuilder data = new StringBuilder();
        Node currentNode = list.head;
        System.out.print("LinkedList: ");

        while (currentNode != null){
            data.append(currentNode.getData()).append(" ");

            currentNode = currentNode.getPointer();
        }
        return data.toString();
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }
        newNode.setPointer(null);
        Node last = head;
        while (last.getPointer() != null){
            last = last.getPointer();
            last.setPointer(newNode);
        }
    }

    public int getHeadData() {
        if(isEmpty()){
            throw new NoSuchElementException("No such element exist in list");
        }
            return head.getData();
    }

    public int getTail() {
        if(isEmpty()){
            throw new NoSuchElementException("No such element exist in list");
        }
        return head.getData();
    }

    public void insertAfter(Node prevNode, int data) {
        if(prevNode == null){
           throw new NullPointerException("Previous node address is not found");
        }

        Node newNode = new Node(data);
        newNode.setPointer(prevNode.getPointer());
        prevNode.setPointer(newNode);
    }

    public Node getHead() {
        return head;
    }

    public void deleteNode(int position) {
        if(isEmpty()){
            return;
        }
        Node temp = head;
        if(position == 0){
            head = temp.getPointer();
            return;
        }
        temp = getDeletedPointer(position, temp);
        if(isPointerExist(temp))
                return;

        removeNode(temp);

    }

    private boolean isPointerExist(Node temp) {
        return temp == null || temp.getPointer() == null;
    }

    private Node getDeletedPointer(int position, Node temp) {
        for(int count = 1; temp != null && count < position - 1; count++)
            temp = temp.getPointer();
        return temp;
    }

    private void removeNode(Node temp) {
        Node next = temp.getPointer().getPointer();
        temp.setPointer(next);
    }

    public Node search(int data) {
        Node temp = head;
        while (temp != null){
            if(temp.getData() == data){
                return temp;
            }
            temp = temp.getPointer();
        }
        return null;
    }
}
