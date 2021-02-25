package non_Linear.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node root;

    public void add(int value){
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value){
        if(isEmpty(current)){
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
        if(isEmpty(current)){
            return false;
        }

        if(value == current.getData()){
            return true;
        }

        return value < current.getData() ? containNodeRecursive(current.getLeft(), value) : containNodeRecursive(current.getRight(), value);
    }

    private boolean isEmpty(Node current) {
        return current == null;
    }

    public boolean containsNode(int value){
        return containNodeRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value){
        if(isEmpty(current)){
            return null;
        }
        if(value == current.getData()){
            if(isEmpty(current.getLeft()) && isEmpty(current.getRight())){
                return null;
            }

            if(isEmpty(current.getRight())){
                return current.getLeft();
            }
            if(isEmpty(current.getLeft())){
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
        return isEmpty(root.getLeft()) ? root.getData() : findSmallestValue(root.getLeft());
    }

    public void delete(int value){
        root = deleteRecursive(root, value);
    }

    public void traverseInOrder(Node node){
        if(!isEmpty(node)){
            traverseInOrder(node.getLeft());
            System.out.println(" " + node.getData());
            traverseInOrder(node.getRight());
        }
    }

    public void traversePreOrder(Node node){
        if(!isEmpty(node)){
            System.out.println(" " + node.getData());
            traversePreOrder(node.getLeft());
            traversePreOrder(node.getRight());
        }
    }

    public void traversePostOrder(Node node){
        if(!isEmpty(node)){
            traversePreOrder(node.getLeft());
            traversePreOrder(node.getRight());
            System.out.println(" " + node.getData());
        }
    }

    public void traverseLevelOrder(){
        if(isEmpty(root)){
            return;
        }

        Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(root);

        while (!nodes.isEmpty()){
            Node node = nodes.remove();
            System.out.print(" " + node.getData());

            if(isEmpty(node.getLeft())){
                nodes.add(node.getLeft());
            }

            if(isEmpty(node.getRight())){
                nodes.add(node.getRight());
            }
        }
    }
}

