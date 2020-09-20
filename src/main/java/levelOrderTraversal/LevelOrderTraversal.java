package levelOrderTraversal;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class LevelOrderTraversal {

    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    private static LinkedList<Node> queue = new LinkedList<>();


    public static void bfs(Node root) {
        while (!queue.isEmpty()) {
            Node el = queue.removeFirst();
            System.out.println(el);
            if (el.left != null)
                queue.add(el.left);
            if (el.right != null)
                queue.add(el.right);

        }

    }
    public static void levelOrder(Node root) {
        queue.add(root);
        bfs(root);
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}