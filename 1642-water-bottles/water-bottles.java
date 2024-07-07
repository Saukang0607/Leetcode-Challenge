class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles, exchangedBottles = 1;
        while(exchangedBottles > 0){
            exchangedBottles = numBottles / numExchange; //after drinking
            numBottles -= numExchange * exchangedBottles; //exchanging
            numBottles += exchangedBottles;//get new bottles
            ans += exchangedBottles; 
        }
        return ans;
    }
}