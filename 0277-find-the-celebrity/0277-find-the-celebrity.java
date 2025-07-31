/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        Map<Integer, Integer> adjList = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j &&knows(i, j) ){
                    adjList.put(j, adjList.getOrDefault(j, 0) + 1);
                }
            }
        }
        for (int person = 0; person < n; person++) {
            if (adjList.getOrDefault(person, 0) == n - 1) {
                boolean knowsNobody = true;
                for (int k = 0; k < n; k++) {
                    if (k != person && knows(person, k)) {
                        knowsNobody = false;
                        break;
                    }
                }
                if (knowsNobody) return person;
            }
        }

        return -1;
    }
}