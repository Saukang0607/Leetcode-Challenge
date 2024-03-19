class Solution {

    public int[][] sortPoints(int[][] points) {
        Arrays.sort(points, (point1, point2) -> Integer.compare(point1[1], point2[1]));
        return points;
    }

    public int findMinArrowShots(int[][] points) {
        points = sortPoints(points);
        System.out.println(points);
        int ans = 1;
        int pos = points[0][1]; // right bound of first balloon
        for (int[] point : points) {
            if (pos < point[0]) { // connot burst together
                ans++;
                pos = point[1];
            }
        }
        return ans;
    }
}
