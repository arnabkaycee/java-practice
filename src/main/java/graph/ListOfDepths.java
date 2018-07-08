package graph;

import graph.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ListOfDepths {


    private ArrayList<LinkedList<TreeNode<Integer>>> outputArray = new ArrayList<>();

    private TreeNode<Integer> rootNode;

    public ArrayList<LinkedList<TreeNode<Integer>>> getOutputArray() {
        return outputArray;
    }

    public TreeNode<Integer> getRootNode() {
        return rootNode;
    }

    private void initTree() {
        rootNode = new TreeNode<>(12);
        TreeNode<Integer> l1 = new TreeNode<>(17);
        TreeNode<Integer> r1 = new TreeNode<>(19);
        rootNode.setLeft(l1);
        rootNode.setRight(r1);

        TreeNode<Integer> ll = new TreeNode<>(20);
        TreeNode<Integer> lr = new TreeNode<>(18);
        l1.setLeft(ll);
        l1.setRight(lr);

        TreeNode<Integer> rl = new TreeNode<>(16);
        TreeNode<Integer> rr = new TreeNode<>(15);
        r1.setLeft(rl);
        r1.setRight(rr);


//        TreeNode <Integer> lll = new TreeNode<>(27);
//        TreeNode <Integer> llr = new TreeNode<>(92);
//
//        TreeNode <Integer> lrl = new TreeNode<>(11);
//        TreeNode <Integer> lrr = new TreeNode<>(16);


    }

    //private Queue<TreeNode<Integer>> queue = new LinkedList<>();

    public void generateLinkedList(TreeNode<Integer> root, int level) {

        if (root == null) return;

        if (outputArray.size() < level) outputArray.add(new LinkedList<>());

        LinkedList<TreeNode<Integer>> listAtDepth = outputArray.get(level - 1);
        listAtDepth.add(root);

        TreeNode<Integer> left = root.getLeft();

        if (left != null) {
            generateLinkedList(left, level + 1);
        }

        TreeNode<Integer> right = root.getRight();

        if (right != null) {
            generateLinkedList(right, level + 1);
        }
    }

    public static void main(String[] args) {
        ListOfDepths listOfDepths = new ListOfDepths();
        listOfDepths.initTree();
        listOfDepths.generateLinkedList(listOfDepths.getRootNode(), 1);
        ArrayList<LinkedList<TreeNode<Integer>>> outputArray = listOfDepths.getOutputArray();
        for (LinkedList<TreeNode<Integer>> el : outputArray) {
            System.out.println(Arrays.toString(el.toArray()));
        }
    }

}



