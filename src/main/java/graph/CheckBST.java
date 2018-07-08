package graph;

// INITIAL CODE

// A Binary Search Tree node
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class CheckBST {

    public static void main(String args[]) {
        Node node = new Node(17);
        Node l1 = new Node(15);
        Node r1 = new Node(19);
        Node l11 = new Node(7);
        Node l12 = new Node(16);
        Node r11 = new Node(18);
        Node r12 = new Node(20);
        node.left = l1;
        node.right = r1;
        l1.left = l11;
        l1.right = l12;
        r1.left = r11;
        r1.right = r12;

        System.out.println(GfG.isBST(node) != 0);


    }
}



class GfG {


    static int isBST(Node root) {
        int predecessor = 0, successor = 0;
        boolean isBST = true;
        boolean hasPredecessor = false, hasSuccessor = false;
        if (root.left != null) {
            predecessor = isBST(root.left);
            hasPredecessor = true;
        }

        if (root.right != null) {
            successor = isBST(root.right);
            hasSuccessor = true;
        }

        if (hasPredecessor) {
            isBST = isBST && (root.data > predecessor && predecessor != 0);
        }
        if (hasSuccessor) {
            isBST = isBST && (root.data < successor && successor != 0);
        }
        if (isBST) {
            return root.data;
        } else {
            return 0;
        }

    }


}