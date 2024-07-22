class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        var idx = new Integer[n];
        for(int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (i, j) -> heights[i] - heights[j]);
        System.out.println(Arrays.toString(idx));
        var ans = new String[n];
        for(int i = n - 1; i >= 0; --i) ans[n - 1 - i] = names[idx[i]];
        return ans;
    }
}