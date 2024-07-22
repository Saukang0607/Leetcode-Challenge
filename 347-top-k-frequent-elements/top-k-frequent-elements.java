class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparing(map::get));
        
        int counter = 0;
        System.out.println(map);
        for (Integer num : map.keySet()) {
            if(counter < k){
                queue.add(num);
                counter++;
                continue;
            }

            if (map.get(num) > map.get(queue.peek())) {
                queue.poll();
                queue.add(num);
            }
        }

        int[] result = new int[k];

        for (int i = 0; i < result.length; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}