class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) ->{
            if(a[0] == b[0]){
                return a[1] - b[1]; 
            }
            return a[0] - b[0];
        });
        for(int i = 0; i < mat.length; i++){
            int temp = 0;
            for(int number: mat[i]){
                temp += number;
            }
            heap.add(new int[]{temp,i});
        }
        int[] output = new int[k];
        for(int j = 0; j < k; j++){
            int[] val = heap.poll();
            output[j] = val[1];
        }
        return output;

    }
}