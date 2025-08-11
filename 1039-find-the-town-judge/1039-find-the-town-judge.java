class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) return 1;
        //Judge trusts nobody
        //Everyone trusts the judge
        //Exactly one person that satisfies 1 & 2
        Set<Integer> seen = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int output = -1;
        for(int[] pair : trust){
            if(!map.containsKey(pair[1])){
                map.put(pair[1], new ArrayList<>());
            }
            map.get(pair[1]).add(pair[0]);
            seen.add(pair[0]);
        }
        //list size should == n - 1
        int count = 0;
        for(int key : map.keySet()){
            if(map.get(key).size() == n - 1 && !seen.contains(key)){
                count++;
                output = key;
            }
        }
        if(count == 1){
            return output;
        } else {
            return -1;
        }
    }
}