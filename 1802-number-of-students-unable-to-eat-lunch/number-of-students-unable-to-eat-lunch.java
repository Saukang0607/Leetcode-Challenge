class Solution {
    public int countStudents(int[] a, int[] b) {
        int[] cnts = new int[2];
        for (int x : a) cnts[x]++;
        for (int i = 0; i < b.length; i++) {
            if (--cnts[b[i]] == -1) return b.length - i;
        }
        return 0;
    }
}

