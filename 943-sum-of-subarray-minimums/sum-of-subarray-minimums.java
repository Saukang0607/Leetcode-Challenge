class Solution {
    private static final int MOD = 1000000007;
    public int sumSubarrayMins(int[] arr) {
        if (arr.length == 1) return arr[0];
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>(); //the higher the smaller

        for(int i = 0; i < arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) stack.pop();
            if(stack.isEmpty()) left[i] = -1;
            else left[i] = stack.peek(); //left boundary found
            stack.push(i);
        }

        stack.clear();
        for(int i = arr.length-1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            if(stack.isEmpty()) right[i] = arr.length;
            else right[i] = stack.peek(); //right boundary found
            stack.push(i);
        }

        long ans = 0;
        for(int i = 0; i < arr.length; i++){
            ans = (ans + (long)(i-left[i])*(right[i]-i)*arr[i]) % MOD;
        }
        return (int)ans;
    }
}