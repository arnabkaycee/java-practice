package nodesAtDistanceK;

public class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode (int data){
        this.data = data;
    }
    TreeNode (){}

    TreeNode left(int data){
        this.left = new TreeNode();
        this.left.data = data;
        return this;
    }

    TreeNode right(int data){
        this.right = new TreeNode();
        this.right.data = data;
        return this;
    }

    @Override
    public String toString() {
        return this.data+"";
    }
}
