public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int mask = 1 << 30; // 最高位开始
        int ans = 0;
        while (mask > 0 && (m & mask) == (n & mask)) { // 寻找相同前缀
            ans |= m & mask;
            mask >>= 1;
        }
        return ans;
    }
}
