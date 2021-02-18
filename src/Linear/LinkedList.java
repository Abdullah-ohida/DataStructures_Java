package Linear;

import java.util.List;

public class LinkedList {
    private Node list;

    public void insertAtBeginning(int data){
        Node newNode = new Node(data);
        newNode.setNext(list);
        list = newNode;
    }

    public Node getList() {
        return list;
    }

    public void setList(Node list) {
        this.list = list;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtBeginning(8);
        list.insertAtBeginning(9);
        System.out.println(list.getList().getNext());
    }
}
