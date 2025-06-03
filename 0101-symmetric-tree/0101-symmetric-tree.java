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
    public boolean isSymmetric(TreeNode root) {
        //Intuition simply check if node.left == node.right
        //Need subtrees
        return dfs(root.left, root.right);
    }
    public boolean dfs(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;  //Returns true if both are equal at base case
        }
        if(left == null || right == null || left.val != right.val){
            return false; //Returns false if one is null and other is not and not equal
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

}