package graph;

import graph.model.TreeNode;

import java.util.*;

public class DFS <T>{


    public static <T> void doDFSTree(TreeNode<T> source){

        //bfs without visited set in case of tree will work because there is no cycles in a tree.

        Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();

        stack.add(source);
        while (!stack.isEmpty()){
            TreeNode<T> element = stack.pop();

            TreeNode<T> left = element.getLeft();
            TreeNode<T> right = element.getRight();

            if (left != null){
                stack.add(left);
            }
            if(right!=null){
                stack.add(right);
            }
            System.out.println(element.getData());
        }
    }


    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        TreeNode<Integer> l1 = new TreeNode<Integer>(11);
        TreeNode<Integer> r1 = new TreeNode<Integer>(12);
        TreeNode<Integer> l21 = new TreeNode<Integer>(17);
        TreeNode<Integer> l22 = new TreeNode<Integer>(18);
        TreeNode<Integer> r21 = new TreeNode<Integer>(20);
        TreeNode<Integer> r22 = new TreeNode<Integer>(25);

        root.setLeft(l1);
        root.setRight(r1);
        l1.setLeft(l21);
        l1.setRight(l22);
        r1.setLeft(r21);
        r1.setRight(r22);

        DFS.doDFSTree(root);
    }



}
