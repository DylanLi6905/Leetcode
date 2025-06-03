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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 1. If both roots are null, trees are identical
        if (p == null && q == null) return true;
        // 2. If one is null and the other isn’t, not identical
        if (p == null || q == null) return false;

        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        pQueue.add(p);
        qQueue.add(q);

        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode nodeP = pQueue.poll();
            TreeNode nodeQ = qQueue.poll();

            // 3. Compare values
            if (nodeP.val != nodeQ.val) {
                return false;
            }

            // 4. Check left children existence
            if (nodeP.left != null && nodeQ.left != null) {
                pQueue.add(nodeP.left);
                qQueue.add(nodeQ.left);
            } else if (nodeP.left != null || nodeQ.left != null) {
                // One has a left child, the other does not
                return false;
            }

            // 5. Check right children existence
            if (nodeP.right != null && nodeQ.right != null) {
                pQueue.add(nodeP.right);
                qQueue.add(nodeQ.right);
            } else if (nodeP.right != null || nodeQ.right != null) {
                // One has a right child, the other does not
                return false;
            }
        }

        // 6. Both queues should be empty at the same time
        return pQueue.isEmpty() && qQueue.isEmpty();
    }
}
