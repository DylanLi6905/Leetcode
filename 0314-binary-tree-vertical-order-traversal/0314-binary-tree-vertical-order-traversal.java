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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if(root == null){
            return output;
        }
        Map<Integer, List<Integer>> map = new HashMap<>(); //Stores assigned val - 1 left and + 1 right to node
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        queue.offer(root);
        cols.offer(0);
        int min = 0;
        int max = 0;

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int col = cols.poll();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(node.val);

            if(node.left != null){
                queue.offer(node.left);
                cols.offer(col - 1);
                min = Math.min(min, col - 1);
            }
            if(node.right != null){
                queue.offer(node.right);
                cols.offer(col + 1);
                max = Math.max(max, col + 1);
            }

        }
        for(int i = min; i <= max ;i++){
            output.add(map.get(i));
        }
        return output;
    }
}