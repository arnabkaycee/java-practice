package nodesAtDistanceK;

import java.util.HashSet;
import java.util.Set;

public class NodesAtKDistanceK {

    private boolean nodeFound = false;

    private Set<Integer> nodes = new HashSet<>();
    private Set<Integer> visited = new HashSet<>();

    private boolean lookUpStarted;

    private int getNodesAtDistanceK(TreeNode rootNode, int referenceNode, int k) {
        if (!nodeFound) {
            if (rootNode == null) {
                return k;
            } else if (rootNode.data == referenceNode) {
                nodeFound = true;
            } else {
                k = getNodesAtDistanceK(rootNode.left, referenceNode, k);
                if (!nodeFound) k = getNodesAtDistanceK(rootNode.right, referenceNode, k);
            }
        }
        if (nodeFound) {
            if (rootNode != null) {
                if (k > 0 && !visited.contains(rootNode.data)) {
                    visited.add(rootNode.data);
                    //look down
                    k = getNodesAtDistanceK(rootNode.left, referenceNode, k - 1);
                    k = getNodesAtDistanceK(rootNode.right, referenceNode, k - 1);
                }
                if (k == 0 && !nodes.contains(rootNode.data)) {
                    nodes.add(rootNode.data);
                }
                if (rootNode.data == referenceNode){
                    return k-1;
                }
            }
            return k + 1;
        }
        return k;
    }


    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(10);
        rootNode.left(15).right(20);
        rootNode.left.left(14).right(16);
        rootNode.right.left(21).right(22);

        rootNode.left.left.left(5).right(6);
        rootNode.left.right.left(18).right(19);

        rootNode.left.right.left.left(1).right(2);

        rootNode.left.right.left.left.left(3);

        NodesAtKDistanceK nodesAtKDistanceK = new NodesAtKDistanceK();
        nodesAtKDistanceK.getNodesAtDistanceK(rootNode, 16, 3);

        System.out.println(nodesAtKDistanceK.nodes);
    }
}
