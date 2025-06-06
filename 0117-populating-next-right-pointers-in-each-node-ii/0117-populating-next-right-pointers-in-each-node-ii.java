/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        //Simply run bfs algo
        Queue<Node> queue = new LinkedList<>();
        if(root == null){
            return root;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            Queue<Node> level = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node node = queue.remove();
                if(node.left != null){
                    queue.add(node.left);
                    level.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                    level.add(node.right);
                }
            }
            int sizeTwo = level.size();
            for(int j = 0; j < sizeTwo; j++){
                Node nodeLevel = level.remove();
                if(level.peek() != null){
                    nodeLevel.next = level.peek();
                }
            }

        }
        return root;
    }
}