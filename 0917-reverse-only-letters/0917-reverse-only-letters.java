class Solution {
    public String reverseOnlyLetters(String s) {
        int left = 0, right = s.length()-1;
        char[] arr = s.toCharArray();
        while(left < right){
            while(!Character.isAlphabetic(arr[left]) && left < right){
                left++; 
            }
            while(!Character.isAlphabetic(arr[right]) && left < right){
                right--;
            }
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(arr);
    }
}