class Solution {
    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        int[] charCounter = new int[26];
        for(int i = 0; i < words[0].length(); i++){ //character count for first string
            charCounter[words[0].charAt(i) - 'a']++;
        }

        for(int i = 1; i < words.length; i++){//loop through other strings
            int[] charCounter2 = new int [26];

            for(int j = 0; j < words[i].length(); j++){//character count for other string
                charCounter2[words[i].charAt(j) - 'a']++;
            }

            for(int k = 0; k < 26; k++){ 
                charCounter[k] = Math.min(charCounter[k], charCounter2[k]); //update the minimum count
            }
        }

        for(int i = 0; i < 26; i++){ //adding common characters
            while(charCounter[i] != 0){ 
                char c = (char) (i + 'a');
                ans.add(c + "");
                charCounter[i]--;
            }
        }

        return ans;
    }
}