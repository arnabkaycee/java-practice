package graph;

import graph.model.TreeNode;

public class LCA {



    public TreeNode<Integer> lca(TreeNode<Integer> root, int n1, int n2) {

        if (root == null) return null;

        if (root.getData() == n1 || root.getData() == n2) {
            return root;
        }

        TreeNode<Integer> leftLCA = lca(root.getLeft(), n1, n2);

        TreeNode<Integer> rightLCA = lca(root.getRight(), n1, n2);

        if (leftLCA != null && rightLCA != null) {
            return root;
        } else if (leftLCA != null) {
            return leftLCA;
        } else return rightLCA;

    }
}
