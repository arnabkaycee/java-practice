package nodesAtDistanceK;

import java.util.HashSet;
import java.util.Set;

public class NodesAtKDistanceK {

    private boolean nodeFound = false;

    private Set<Integer> nodes = new HashSet<>();

    private int lookUp;

    private void getNodesAtDistanceK(TreeNode rootNode, int referenceNode, int k) {

        if (!nodeFound) {
            if (rootNode == null) {
                return;
            } else if (rootNode.data == referenceNode) {
                nodeFound = true;
            } else {
                getNodesAtDistanceK(rootNode.left, referenceNode, k);
                if (!nodeFound) getNodesAtDistanceK(rootNode.right, referenceNode, k);
            }
        }
        if (nodeFound && k > 0 && rootNode != null) {
            //look down
            getNodesAtDistanceK(rootNode.left, referenceNode, k - 1);
            getNodesAtDistanceK(rootNode.right, referenceNode, k - 1);
            //look up

        }
        if (nodeFound && k==0 && rootNode != null && !nodes.contains(rootNode.data)){
            nodes.add(rootNode.data);
        }
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
