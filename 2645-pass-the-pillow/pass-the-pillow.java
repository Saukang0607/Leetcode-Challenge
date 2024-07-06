class Solution {
    public int passThePillow(int n, int time) {
        int counter = 0, idx = 0, increment = 1;
        while(counter < time){
            counter++;
            idx += increment;
            if(idx >= n - 1 || idx <= 0) increment *= -1;
        } 
        return idx + 1;
    }
}