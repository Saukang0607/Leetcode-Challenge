class Solution {
    public int minimumDeletions(String S) {
        var s = S.toCharArray();
        int del = 0;
        for (var c : s)
            del += 'b' - c; // 统计 'a' 的个数
        int ans = del;
        for (var c : s) {
            // 'a' -> -1    'b' -> 1
            del += (c - 'a') * 2 - 1;
            ans = Math.min(ans, del);
        }
        return ans;
    }
}
