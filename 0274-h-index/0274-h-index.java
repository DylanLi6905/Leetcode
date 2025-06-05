class Solution {
    public int hIndex(int[] citations) {
        //H index is the max value of h s.t. the researcher has publishged at least h papers and cited at least h times
        Arrays.sort(citations);
        //0 1 3 5 6
        //0 1 2 3 4
        int hVal = 0;
        for(int i = 0; i < citations.length; i++){
            //What makes a valid h val?
            //number of citations with at least the same number of papers cited
            if (citations[i] >= citations.length - i){
                return citations.length - i;
            } 
        }
        return hVal;
    }
}