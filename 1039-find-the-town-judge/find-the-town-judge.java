class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length == 0 && n == 1) return 1;
        else if( trust.length == 0) return -1;
        
        HashMap<Integer, Integer> In = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> Out = new HashMap<Integer, Integer>();
        for (int[] relation : trust) {
            if(In.containsKey(relation[1])) In.put(relation[1], In.get(relation[1]) + 1);
            else In.put(relation[1], 1);
            if(Out.containsKey(relation[0])) Out.put(relation[0], Out.get(relation[0]) + 1);
            else Out.put(relation[0], 1);
        }
        
        System.out.println(In);
        System.out.println(Out);
        for (int key : In.keySet()) {
            Integer value = In.get(key);
            if(value != null && value == n - 1 && !Out.containsKey(key)) return key;
        }

        return -1;
    }
}