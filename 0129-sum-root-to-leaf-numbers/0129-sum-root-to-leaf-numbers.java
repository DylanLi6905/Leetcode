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
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.remove();
                if(node.left == null && node.right == null){
                    sum += node.val;
                }
                if(node.left != null){
                    node.left.val = (node.val * 10) + node.left.val;
                    queue.add(node.left);
                }
                if(node.right != null){
                    node.right.val = (node.val * 10) + node.right.val;
                    queue.add(node.right);
                }
            }
        }
        return sum;
    }
}