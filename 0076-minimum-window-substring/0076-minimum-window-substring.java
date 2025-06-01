class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        String output = "";
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        Map<Character, Integer> temp = new HashMap<>();
        for(int right = 0; right < s.length(); right++){
            temp.put(s.charAt(right), temp.getOrDefault(s.charAt(right), 0) + 1);
            if(isValid(map,temp)){
                if (output.isEmpty() || right - left + 1 < output.length()) {
                    output = s.substring(left, right + 1);
                }
            }
            while(left < right && isValid(map,temp)){
                char lc = s.charAt(left);
                temp.put(lc, temp.get(lc) - 1);
                left++;

                if (isValid(map, temp)) {
                    if (right - left + 1 < output.length()) {
                        output = s.substring(left, right + 1);
                    }
                }
            }
        }
        return output;
    }
    public boolean isValid(Map<Character, Integer> t, Map<Character, Integer> temp){
        for(char letter : t.keySet()){
            if(!temp.containsKey(letter) || temp.get(letter) < t.get(letter)){
                return false;
            }
        }
        return true;
    }
}