/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> output;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        output = new ArrayList<>();
        if(root == null){
            return output;
        }
        if (!isLeaf(root)) {
    output.add(root.val);
} //if left child of root exists then perform left boundary op
            left(root.left);
        leaf(root);
        right(root.right);
        return output;
    }
    public boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
    public void left(TreeNode node){
        while (node != null) {
        if (!isLeaf(node)) output.add(node.val);
        if (node.left != null) {
            node = node.left;
        } else {
            node = node.right;
        }
    }
    }
    public void leaf(TreeNode node){
        if(node == null){
            return;
        }
        leaf(node.left);
        leaf(node.right);
        if(isLeaf(node)){
            output.add(node.val);
        }
    }
    public void right(TreeNode node) {
        if (node == null || isLeaf(node)) return;

        if (node.right != null) {
            right(node.right);
        } else if (node.left != null) {
            right(node.left);
        }
        output.add(node.val);
    }
}