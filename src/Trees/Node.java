package Trees;

public class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data, Node left, Node right){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData(){
        return this.data;
    }

    public Node getLeft(){
        return this.left;
    }

    public Node getRight(){
        return this.right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right){
        this.right = right;
    }
}
