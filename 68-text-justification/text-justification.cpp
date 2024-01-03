class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        vector<string> ans;
        int cnt = 0;
        int bg = 0;
        for (int i = 0; i <words.size(); i ++ ){
            cnt += words[i].size()+1;
            if(i+1 == words.size() || cnt + words[i+1].size() > maxWidth){
                ans.push_back(fillWords(words,bg, i, maxWidth, i + 1 == words.size()));
                bg = i + 1;
                cnt = 0;
            }
        }
        return ans;
    }

    string fillWords(vector<string>& words, int bg, int ed, int maxWidth, bool lastLine){
        int wordCount = ed - bg + 1;
        int spaceCount = maxWidth + 1 - wordCount; //minus the default space
        for (int i = bg; i <= ed; i++){
            spaceCount -= words[i].size();
        }

        int defaultSpace = 1;
        int averageSpace = (wordCount == 1) ? 1 : spaceCount / (wordCount - 1);
        int extraSpace = (wordCount == 1) ? 0 : spaceCount % (wordCount - 1);

        string ans;
        for(int i= bg; i <= ed; i++){
            ans += words[i];
            if (lastLine && i != ed){ //cuz last line is left justified
                fill_n(back_inserter(ans),1,' ');
                continue;
            }

            if(i == ed){
                    fill_n(back_inserter(ans), maxWidth - ans.size(), ' ');
            }
            else{
                fill_n(back_inserter(ans),defaultSpace + averageSpace + ((i - bg) < extraSpace), ' '); //fill up corresponding spaces
            }
        }
        return ans;
    }
};
