class Solution {
    public double averageWaitingTime(int[][] customers) {
        double prev = customers[0][0] + customers[0][1], sum = customers[0][1];
        for(int i = 1; i < customers.length; i++){
            if(prev <= customers[i][0]){
                prev = customers[i][0] + customers[i][1];
                sum += customers[i][1];
            }
            else{
                prev += customers[i][1];
                sum += (prev - customers[i][0]);
            }
        }

        return (double) sum / customers.length;
    }
}