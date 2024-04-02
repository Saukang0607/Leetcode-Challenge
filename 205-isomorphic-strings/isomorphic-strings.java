class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false; // Early check for different lengths

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check for one-to-one mapping in s
            if (map.containsKey(charS)) {
                if (map.get(charS) != charT) {
                    return false;
                }
            } else {
                // Check for onto mapping in t (no duplicate mappings in t for same char in s)
                if (map.containsValue(charT)) {
                    return false;
                }
                map.put(charS, charT);
            }
        }

        return true;
    }
}
