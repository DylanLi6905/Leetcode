class FirstUnique {
    private Queue<Integer> unique;
    private Map<Integer, Integer> map;

    public FirstUnique(int[] nums) {
        unique = new LinkedList<>();
        map = new HashMap<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        while (!unique.isEmpty() && map.get(unique.peek()) > 1) {
            unique.poll();
        }
        return unique.isEmpty() ? -1 : unique.peek();
    }

    public void add(int value) {
        map.put(value, map.getOrDefault(value, 0) + 1);
        if (map.get(value) == 1) {
            unique.offer(value);
        }
    }
}
