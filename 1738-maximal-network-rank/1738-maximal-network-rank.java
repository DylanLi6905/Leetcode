class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>()); // ensure every city exists
        }
        for (int[] road : roads) {
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        }
        int output = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = map.get(i).size() + map.get(j).size();
                if (map.get(i).contains(j)) {
                    rank -= 1; // subtract shared road
                }
                output = Math.max(output, rank);
            }
        }
        return output;
    }
}