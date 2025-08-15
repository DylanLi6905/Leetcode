class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int output = 1;
        int[] prev = pairs[0];
        for(int i = 1; i < pairs.length; i++){
            if(pairs[i][0] > prev[1]){
                output++;
                prev = pairs[i];
            }
        }
        return output;
    }
}