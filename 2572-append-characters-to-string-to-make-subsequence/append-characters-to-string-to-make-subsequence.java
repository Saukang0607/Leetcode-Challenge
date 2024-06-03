class Solution {
    public int appendCharacters(String s, String t) {
        int left_ptr = 0, right_ptr = 0, ans = 0, t_len = t.length(), s_len = s.length();
        while(right_ptr < t_len){

            if(left_ptr >= s_len){ //reached end of s, need to append characters
                ans++;
                right_ptr++;
                continue;
            }

            if(s.charAt(left_ptr) == t.charAt(right_ptr)){
                left_ptr++;
                right_ptr++;
            }
            else left_ptr++;
        }
        return ans;

    }
}