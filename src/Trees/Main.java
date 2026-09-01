package Trees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        createBinaryTreeLevelWise();
//        Queue<Integer> q = new ArrayDeque<>();
//        q.offer(2);
//        q.offer(3);
//        q.offer(4);
//        q.offer(-1);
//        q.offer(-1);
//        q.offer(5);
//        q.offer(-1);
//        q.offer(-1);
//        q.offer(-1);
//        q.offer(20);
//
//        Node root = new Node(1, null, null);
//        createBinaryTreeRecursively(q, root);
        backtrack();
    }

    public static Node backtrack(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter node value: ");
        int val = scanner.nextInt();
        if (val == -1) return null;
        Node node = new Node(val, null, null);

        Node left = backtrack();
        if (left != null) {
            node.setLeft(left);
        }

        Node right = backtrack();
        if (right != null){
            node.setRight(right);
        }
        return node;
    }

    public static void createBinaryTreeLevelWise(){
        Queue<Node> q = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your root value: ");
        int rootVal = scanner.nextInt();
        Node root = new Node(rootVal, null, null);
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.printf("Enter left child for node %d: ", temp.getData());
            int leftVal = scanner.nextInt();

            if (leftVal != -1) {
                Node leftNode = new Node(leftVal, null, null);
                temp.setLeft(leftNode);
                q.add(leftNode);
            }

            System.out.printf("Enter right child for node %d: ", temp.getData());
            int rightVal = scanner.nextInt();
            if (rightVal != -1) {
                Node rightNode = new Node(rightVal, null, null);
                temp.setRight(rightNode);
                q.add(rightNode);
            }
        }
    }
    // {1, 2, 3, 4, -1, -1, 5, -1, -1, -1, 20, -1, -1}
    public static void createBinaryTreeRecursively(Queue<Integer> q, Node root) {
        if (q.isEmpty()){
            return;
        }

//        if (q.peek() == -1) {
//            q.poll();
//            return;
//        }

        // create left
        Node temp = null;
        if (q.peek() != -1){
            temp = new Node(q.poll(), null, null);
            root.setLeft(temp);
            createBinaryTreeRecursively(q, temp);
        } else {
            q.poll();
        }

        // explore right
        if (!q.isEmpty() && q.peek() != -1){
            temp = new Node(q.poll(), null, null);
            root.setRight(temp);
            createBinaryTreeRecursively(q, temp);
        } else {
            q.poll();
        }
    }

}
