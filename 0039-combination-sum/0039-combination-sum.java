class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(output, new ArrayList<>(), candidates, target, 0);
        return output;
    }
    public void backtrack(List<List<Integer>> output, List<Integer> curr, int[] candidates, int target, int start){
        if (target == 0) {
            output.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0) {
            return;
        }
        for(int i = start; i < candidates.length; i++){
            curr.add(candidates[i]);
            backtrack(output, curr, candidates, target - candidates[i], i);
            curr.remove(curr.size() - 1);
        }
    }
    
}