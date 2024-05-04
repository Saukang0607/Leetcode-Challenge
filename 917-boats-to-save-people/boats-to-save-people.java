class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int front = 0, end = people.length - 1, boats = 0;
        while(front <= end){
            if(people[front] + people[end] <= limit){
                boats ++;
                front++; 
                end--; //two ppl has fetched by boat
            }
            else{
                boats ++;
                end--; //only heavy person is fetched, greedy algorithm
            }
        }
        return boats;
    }
}