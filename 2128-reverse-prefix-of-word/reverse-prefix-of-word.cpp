class Solution {
public:
    string reversePrefix(string word, char ch) {
        int index = word.find(ch);
        cout << index << "\n";
        cout << string::npos;
        reverse(word.begin(), word.begin() + index + 1); //not inclusive so +1 is required
        return word;
    }
};