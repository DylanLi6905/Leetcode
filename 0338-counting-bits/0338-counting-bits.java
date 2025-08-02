class Solution {
    public int[] countBits(int n) {
        int[] output = new int[n+1];
        for(int i = 0; i <= n; i++){
            output[i] = numOnes(i);
        }
        return output;
    }
    public int numOnes (int n){
        int count = 0;
        while(n != 0){
            if(n % 2 == 1){
                count++;
            }
            n /= 2;
        }
        return count;
    }
}