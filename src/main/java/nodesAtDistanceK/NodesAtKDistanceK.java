package nodesAtDistanceK;

import java.util.HashSet;
import java.util.Set;

public class NodesAtKDistanceK {

    private boolean nodeFound = false;

    private Set<Integer> nodes = new HashSet<>();

    private void getNodesAtDistanceK(TreeNode rootNode, int referenceNode, int k){

        if (nodeFound){



        }else {
            if (rootNode == null){
                return;
            }else if (rootNode.data ==  referenceNode){
                nodeFound = true;
            }else {
                getNodesAtDistanceK(rootNode.left, referenceNode, k -1);
                if (!nodeFound) getNodesAtDistanceK(rootNode.right, referenceNode, k -1);
            }
        }
    }

}
