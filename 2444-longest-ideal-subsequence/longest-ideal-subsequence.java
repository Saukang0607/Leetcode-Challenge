class Solution {
    public int longestIdealString(String s, int k) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) {
            c -= 'a';
            for (int j = Math.max(c - k, 0); j <= Math.min(c + k, 25); j++) {
                f[c] = Math.max(f[c], f[j]);
            }
            f[c]++;
        }
        return Arrays.stream(f).max().getAsInt();
    }
}

