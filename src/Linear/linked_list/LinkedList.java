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
        return 0;
    }
}
