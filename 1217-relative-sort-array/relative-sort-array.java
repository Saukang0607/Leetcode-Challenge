class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : arr1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        System.out.println(map);

        int idx = 0;
        for(int i = 0; i < arr2.length; i++){
            while(map.get(arr2[i]) > 0){
                arr1[idx++] = arr2[i];
                map.put(arr2[i], map.get(arr2[i])-1);
            }
            map.remove(arr2[i]);
        }

        TreeMap<Integer, Integer> sorted = new TreeMap<>(map);
        for (Map.Entry<Integer, Integer> entry : sorted.entrySet()) {
            int count = entry.getValue();
            while(count > 0){
                arr1[idx++] = entry.getKey();
                count--;
            }
        }
        return arr1;
    }
}