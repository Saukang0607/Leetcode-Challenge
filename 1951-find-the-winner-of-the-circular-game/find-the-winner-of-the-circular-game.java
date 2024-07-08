class Solution {
    public int findTheWinner(int n, int k) {
        boolean[] vis = new boolean[n];
        int idx = 0;
        for(int i = 1; i < n; i++){
            for(int j = 1; j < k; j++){ //removing one loser
                idx++;
                while(vis[idx % n]) idx++; //skip the person ady lost
            }
            vis[idx % n] = true;
            idx++; //immediately start from the next
            while(vis[idx % n]) idx++; 
        }

        return (idx % n) + 1; 
    }
}

