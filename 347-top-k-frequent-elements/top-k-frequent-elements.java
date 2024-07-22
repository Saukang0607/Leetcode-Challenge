class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparing(map::get));

        for (Integer num : map.keySet()) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] result = new int[k];

        for (int i = 0; i < result.length; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}