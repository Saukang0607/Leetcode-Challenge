class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect
        (Collectors.groupingBy(s -> {
            int[] counter = new int[26];
            for(int i = 0; i < s.length(); i++){
                counter[s.charAt(i)- 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++){
                if(counter[i] != 0){
                    sb.append((char) ('a' + i));
                    sb.append(counter[i]);
                }
            }
            return sb.toString();
        })).values());
    }
}