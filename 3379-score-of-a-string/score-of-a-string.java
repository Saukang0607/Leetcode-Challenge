class Solution {
    public int scoreOfString(String s) {
        int ans = 0;
        for(int i = 1; i < s.length(); i++){
            int back = 'a' - s.charAt(i);
            int front = 'a' - s.charAt(i-1);
            if(front > back){
                ans += front - back;
            }
            else{
                ans += back - front;
            }
        }
        return ans;
    }
}