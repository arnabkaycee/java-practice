package graph;

import graph.model.TreeNode;

public class CheckBalancedBST {

    private TreeNode<Integer> rootNode;


    public TreeNode<Integer> getRootNode() {
        return rootNode;
    }

    private void initTree() {
        rootNode = new TreeNode<>(12);
        TreeNode<Integer> l1 = new TreeNode<>(17);
        //TreeNode<Integer> r1 = new TreeNode<>(19);
        rootNode.setLeft(l1);
        //rootNode.setRight(r1);

        TreeNode<Integer> ll = new TreeNode<>(20);
        TreeNode<Integer> lr = new TreeNode<>(18);
        l1.setLeft(ll);
        l1.setRight(lr);

        TreeNode<Integer> rl = new TreeNode<>(16);
        TreeNode<Integer> rr = new TreeNode<>(15);
        //r1.setLeft(rl);
        //r1.setRight(rr);

    }




    public int getHeight (TreeNode<Integer> rootNode, int height){

        if (rootNode == null) return height-1;

        int leftTreeHeight = height, rightTreeHeight = height;
        if (rootNode.getLeft()!=null)
            leftTreeHeight = getHeight(rootNode.getLeft(), height+1);

        if (rootNode.getRight()!=null)
            rightTreeHeight = getHeight((rootNode.getRight()), height+1);

        return Math.max(leftTreeHeight,rightTreeHeight);

    }


    public static void main(String[] args) {
        CheckBalancedBST checkBalancedBST = new CheckBalancedBST();
        checkBalancedBST.initTree();
        int leftTreeHeight = checkBalancedBST.getHeight(checkBalancedBST.getRootNode().getLeft(),1);
        int rightTreeHeight = checkBalancedBST.getHeight(checkBalancedBST.getRootNode().getRight(),1);
        System.out.println(Math.abs(leftTreeHeight-rightTreeHeight) > 1 ? "no" : "yes");
    }



}
