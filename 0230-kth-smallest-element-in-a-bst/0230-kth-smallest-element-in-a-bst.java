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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = dfs(root, new ArrayList<Integer>());
        return list.get(k-1);
    }
    public ArrayList<Integer> dfs(TreeNode root, ArrayList<Integer> empty){
        if(root == null){
            return empty;
        }
        dfs(root.left, empty);
        empty.add(root.val);
        dfs(root.right, empty);
        return empty;
    }
}