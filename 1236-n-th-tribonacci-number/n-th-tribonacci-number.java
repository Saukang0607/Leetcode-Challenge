class Solution {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        else if(n == 1 || n == 2) return 1;

        int Tn = 0, Tn1 = 1, Tn2 = 1;
        int ans = 0;
        for(int i = 0; i < n -2 ; i++){
            ans = Tn + Tn1 + Tn2;
            Tn = Tn1;
            Tn1= Tn2;
            Tn2 = ans;
        }

        return ans;
    }
}