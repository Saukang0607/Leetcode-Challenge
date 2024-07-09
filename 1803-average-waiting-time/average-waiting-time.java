class Solution {
    public double averageWaitingTime(int[][] customers) {
        double prev = customers[0][0] + customers[0][1], sum = customers[0][1]; //use double to prevent overflow
        //prev is previous order done time

        for(int i = 1; i < customers.length; i++){
            if(prev <= customers[i][0]){ //if previous order is done before next one
                prev = customers[i][0] + customers[i][1];
                sum += customers[i][1];
            }
            else{ //still cooking previous order wehn getting new order
                prev += customers[i][1];
                sum += (prev - customers[i][0]);
            }
        }

        return (double) sum / customers.length;
    }
}