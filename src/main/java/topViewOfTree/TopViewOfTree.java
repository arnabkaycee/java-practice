package topViewOfTree;


import java.util.*;


/**
 * Sample input
 * 116
 * <p>
 * 37 23 108 59 86 64 94 14 105 17 111 65 55 31 79 97 78 25 50 22 66 46 104 98 81 90 68 40 103 77 74 18 69 82 41 4 48 83 67 6 2 95 54 100 99 84 34 88 27 72 32 62 9 56 109 115 33 15 91 29 85 114 112 20 26 30 93 96 87 42 38 60 7 73 35 12 10 57 80 13 52 44 16 70 8 39 107 106 63 24 92 45 75 116 5 61 49 101 71 11 53 43 102 110 1 58 36 28 76 47 113 21 89 51 19 3
 */


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


class DistancePair {
    int data;
    int height;
    public DistancePair(int data, int height) {
        this.data = data;
        this.height = height;
    }
}

class TopViewOfTree {

    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    private static final StringBuilder sb = new StringBuilder();
    private static TreeMap<Integer, DistancePair> distanceMap = new TreeMap<>();


    public static void topView(Node root) {
        printNodes(root, 0, 0);
        for (Map.Entry<Integer, DistancePair> entry : distanceMap.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
    }






    public static void printNodes (Node root, int distance, int height) {
        if (root == null) return;

        if (!distanceMap.containsKey(distance)) {
            distanceMap.put(distance, new DistancePair(root.data, height));
        }else {
            // if found another node with same horizontal distance, take the one with the lesser height
            DistancePair pair = distanceMap.get(distance);
            if (pair.height > height) {
                distanceMap.put(distance, new DistancePair(root.data, height));
            }
        }
        printNodes(root.left, distance-1, height+1);
        printNodes(root.right, distance+1, height+1);
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
        topView(root);
    }
}