class Solution {
    private int n;
    private int m;
    private int[][] seen;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        n = maze.length;
        m = maze[0].length;
        seen = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        seen[start[0]][start[1]] = 1;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty()){
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            if (r == destination[0] && c == destination[1]) {
                return true;
            }
            for (int[] d : dirs) {
                int x = r, y = c;

                // roll in the direction until hitting wall
                while (isValid(x + d[0], y + d[1]) && maze[x + d[0]][y + d[1]] == 0) {
                    x += d[0];
                    y += d[1];
                }

                // enqueue only if we haven't seen this stopping point
                if (seen[x][y] == 0) {
                    seen[x][y] = 1;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return false;
    }
    public boolean isValid(int row, int col){
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}