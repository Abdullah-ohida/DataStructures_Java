package non_Linear.Tree;

public class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }


    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
       this.right = right;
    }

    public void setData(int data) {
        this.data = data;
    }
}
