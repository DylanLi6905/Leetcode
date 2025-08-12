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
    private Map<TreeNode, List<TreeNode>> map;
    public int amountOfTime(TreeNode root, int start) {
        //Intuition, create and adjacency list and run bfs from the starting node
        map = new HashMap<>();
        Set<TreeNode> seen = new HashSet<>();
        dfs(root, null);
        Queue<TreeNode> q = new LinkedList<>();
        for(TreeNode node : map.keySet()){
            if(node.val == start){
                q.add(node);
                seen.add(node);
                break;
            }
        }
        int output = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                for(TreeNode key : map.get(node)){
                    if(!seen.contains(key)){
                        seen.add(key);
                        q.add(key);
                    }
                }
            }
            output++;
        }
        return output-1;
    }
    public void dfs(TreeNode node, TreeNode prev){
        if(node == null){
            return;
        }
        if(!map.containsKey(node)){
            map.put(node, new ArrayList<>());
        }
        if(prev != null){
            map.get(node).add(prev);
        }
        if(node.left != null){
            map.get(node).add(node.left);
            dfs(node.left, node);
        }
        if(node.right != null){
            map.get(node).add(node.right);
            dfs(node.right, node);
        }
        return;
    }
}