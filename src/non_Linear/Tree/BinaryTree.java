package non_Linear.Tree;

public class BinaryTree {
    private Node root;

    public void add(int value){
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value){
        if(current == null){
            return new Node(value);
        }
        if(value < current.getData()){
            current.setLeft(addRecursive(current.getLeft(), value));
        }else if(value > current.getData()){
            current.setRight(addRecursive(current.getRight(), value));
        }else {
            return current;
        }
        return current;
    }

    public BinaryTree createBinaryTree(BinaryTree tree){
        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);

        return tree;
    }

    private boolean containNodeRecursive(Node current, int value){
        if(current == null){
            return false;
        }

        if(value == current.getData()){
            return true;
        }

        return value < current.getData() ? containNodeRecursive(current.getLeft(), value) : containNodeRecursive(current.getRight(), value);
    }

    public boolean containsNode(int value){
        return containNodeRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value){
        if(current == null){
            return null;
        }
        if(value == current.getData()){
            if(current.getLeft() == null && current.getRight() == null){
                return null;
            }

            if(current.getRight() == null){
                return current.getLeft();
            }
            if(current.getLeft() == null){
                return current.getRight();
            }

            int smallestValue = findSmallestValue(current.getRight());
            current.setData(smallestValue);
            current.setRight(deleteRecursive(current.getRight(), smallestValue));
            return current;
        }

        if(value < current.getData()){
            current.setLeft(deleteRecursive(current.getRight(), value));
            return current;
        }
        current.setRight(deleteRecursive(current.getRight(), value));
        return current;
    }

    private int findSmallestValue(Node root){
        return root.getLeft() == null ? root.getData() : findSmallestValue(root.getLeft());
    }

    public void delete(int value){
        root = deleteRecursive(root, value);
    }
}
