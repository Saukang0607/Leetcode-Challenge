class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        // ... populate the map
        for (int num : arr) {
            countMap.putIfAbsent(num, 0);
            countMap.put(num, countMap.get(num) + 1);
        }
        System.out.println(countMap);
        // Sort the HashMap by values in ascending order
        Map<Integer, Integer> sortedMap = countMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()),
                        LinkedHashMap::putAll);
        // You can now iterate over the sorted entries
        System.out.println(countMap);
        for (int key : new ArrayList<>(sortedMap.keySet())) {
            if (k >= sortedMap.get(key)) {
                k -= sortedMap.get(key);
                sortedMap.remove(key);
            } else {
                break;
            }
        }
        System.out.println(countMap);
        return sortedMap.size();
    }
}