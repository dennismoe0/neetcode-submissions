class Solution {
public:
    bool isAnagram(string s, string t) {

        std::unordered_map<char, int> sCharCounts;
        std::unordered_map<char, int> tCharCounts;

        for (char c : s) {
            sCharCounts[c]++;
        }
        for (char c : t) {
            tCharCounts[c]++;
        }

        bool sameFreq = (sCharCounts == tCharCounts);
        return sameFreq;
    }
};
