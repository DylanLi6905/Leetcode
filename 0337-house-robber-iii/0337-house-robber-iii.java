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
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
    public int[] dfs(TreeNode node){
        if (node == null) return new int[2];
        //Contains the rob value of left and right subtree
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int rob = node.val + left[0] + right[0];
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{notRob, rob};
    }
}