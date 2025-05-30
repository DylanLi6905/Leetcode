class Solution {
    //Need hashSet to make sure the end word is in the wordList;
    Set<String> set;
    //Need Queue to BSF from beginning word
    Queue<String> queue;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        set = new HashSet<>();
        queue = new LinkedList<>();
        int count = 1;
        //Begin cannot equals end word 
        if(beginWord.equals(endWord)){
            return 0;
        }
        queue.add(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String current = queue.remove();
                List<String> temp = neighbors(current, wordList);
                for(String value : temp){
                    if(value.equals(endWord)){
                        return count + 1;
                    }
                    queue.add(value);
                }
            }
            count++;
        }
        return 0;
    }
    //Helper function to find all the valid neighbors within the wordList
    public List<String> neighbors(String word, List<String> bank){
        //Use the set to see if string is visited do not add if visited do not want cycle
        List<String> output = new ArrayList<>();
        for(String valid : bank){
            if(!set.contains(valid) && charDiff(word, valid) == 1){
                output.add(valid);
                set.add(valid);
            }
        }
        System.out.println(output);
        return output;
    }
    // Helper to determine the difference in length between words and diff == 1 is a neighbor
    public int charDiff(String one, String two){
        if(one.length() != two.length()){
            return 0;
        }
        int difference = 0;
        for(int i = 0; i < one.length(); i++){
            if(one.charAt(i) != two.charAt(i)){
                difference++;
            }
        }
        return difference;
    }
}