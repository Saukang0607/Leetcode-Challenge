class Solution {
    public int appendCharacters(String s, String t) {
        int ps = 0, pt = 0;
        while(pt < t.length() && ps < s.length()){
            if(s.charAt(ps) == t.charAt(pt)){
                pt++;
            }
            ps++;
        }
        return t.length() - pt;
    }
}