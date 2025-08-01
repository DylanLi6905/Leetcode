class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        //Given list of pid and ppid where index i shows pid and pid parent
        Map<Integer, List<Integer>> adjList = new HashMap<>(); //Maps parents to children.
        //Find the kill node and bfs to remove all children
        for(int i = 0; i < ppid.size(); i++){
            if(!adjList.containsKey(ppid.get(i))){
                adjList.put(ppid.get(i), new ArrayList<>());
            }
            adjList.get(ppid.get(i)).add(pid.get(i));
        }
        List<Integer> output = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(kill);
        Set<Integer> seen = new HashSet<>();
        seen.add(kill);
        output.add(kill);
        while (!q.isEmpty()) {
            int temp = q.poll();
            if (adjList.containsKey(temp)) {
                for (int child : adjList.get(temp)) {
                    output.add(child);
                    q.add(child);
                }
            }
        }
        return output;
    }
}