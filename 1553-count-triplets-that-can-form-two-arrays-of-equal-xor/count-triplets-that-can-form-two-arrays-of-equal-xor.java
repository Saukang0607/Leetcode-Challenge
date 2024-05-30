class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int[] prefixXor = new int[n+1];
        for(int i = 0; i < n; i++){
            prefixXor[i+1] = prefixXor[i]^arr[i];
        }

        for(int i = 1; i <=n; i++){
            for(int j = i+1; j <=n; j++){
                for(int k = j; k <=n; k++){
                    int a = prefixXor[i-1]^prefixXor[j-1];
                    int b = prefixXor[j-1]^prefixXor[k];
                    ans += a==b ? 1 : 0;
                }
            }
        }

        return ans;
    }
}