package HeightOfBinaryTree;

import java.util.Scanner;

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

class HeightOfBinaryTree {

    /*
    class HeightOfBinaryTree.Node
        int data;
        HeightOfBinaryTree.Node left;
        HeightOfBinaryTree.Node right;
    */

    public static int height(Node root, int height) {
        // Write your code
        return getHeight(root, -1);
    }


    public static int getHeight(Node root, int height) {
        // Write your code here.
        if (root == null)
            return height;

        height = Math.max(
                height(root.left, height+1),
                height(root.right, height+1)
        );



        return height;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
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
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root,0);
        System.out.println(height);
    }
}