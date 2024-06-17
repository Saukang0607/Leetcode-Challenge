class Solution {
    public boolean judgeSquareSum(int c) {
        int bound = (int) Math.floor(Math.sqrt(c)) + 1;
        int[] array = new int[bound];
        for(int i = 0; i < bound; i++){
            array[i] = i;
        }

        int left = 0, right = bound - 1;
        while(left <= right){
            if(Math.pow(array[left],2) + Math.pow(array[right],2) == c){
                return true;
            }

            else if(Math.pow(array[left],2) + Math.pow(array[right],2) < c){
                left++;
            }

            else if(Math.pow(array[left],2) + Math.pow(array[right],2) > c){
                right--;
            }
        }
        return false;
    }
}