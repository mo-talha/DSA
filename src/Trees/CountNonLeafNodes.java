package Trees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class CountNonLeafNodes {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Node root = createTree();
        countNonLeafNodes(root);
        System.out.println(count);
    }
    static int count = 0;
    public static void countNonLeafNodes(Node node){
        if (node == null) return;

        if (node.getLeft() != null && node.getRight() != null) count += 1;

        countNonLeafNodes(node.getLeft());

        countNonLeafNodes(node.getRight());
    }

//    public static Node createTree(){
//        System.out.print("Enter Value: ");
//        int val = scanner.nextInt();
//
//        if (val == -1) return null;
//
//        Node node = new Node(val, null, null);
//
//        Node left = createTree();
//        if (left != null) node.setLeft(left);
//
//        Node right = createTree();
//        if (right != null) node.setRight(right);
//
//        return node;
//    }
    // [1, 2, 3, -1, -1, 4, -1, -1, 5, -1, -1]
    public static Node createTree(){
        Queue<Node> q = new ArrayDeque<>();

        System.out.println("Enter the root value: ");
        int rootVal = scanner.nextInt();

        if (rootVal == -1) return null;

        Node rootNode = new Node(rootVal, null, null);
        q.add(rootNode);

        while (!q.isEmpty()){
            Node temp = q.poll();

            System.out.printf("Enter left child of %d: ", temp.getData());
            int leftVal = scanner.nextInt();
            if (leftVal != -1) {
                Node left =new Node(leftVal, null, null);
                temp.setLeft(left);
                q.add(left);
            }

            System.out.printf("Enter right child of %d: ", temp.getData());
            int rightVal = scanner.nextInt();
            if (rightVal != -1){
                Node right = new Node(rightVal, null, null);
                temp.setRight(right);
                q.add(right);
            }
        }
        return rootNode;
    }
}
