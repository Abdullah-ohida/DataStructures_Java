package Linear.linked_list;

public class Node {
    private int data;
    private Node pointer;

    public Node(int data) {
        this.data = data;
        pointer = null;
    }

    public Node getPointer() {
        return pointer;
    }

    public void setPointer(Node pointer) {
        this.pointer = pointer;
    }

    public int getData() {
        return data;
    }
}
