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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {
                if (node.val == targetSum) {
                    return true;
                }
                continue;
            }
            if(node.left != null){
                node.left.val = node.left.val + node.val;
                queue.add(node.left);
            }
            if(node.right != null){
                node.right.val = node.right.val + node.val;
                queue.add(node.right);
            }
        }
        return false;
    }
}