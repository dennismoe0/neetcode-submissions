class Solution {
public:
    bool isAnagram(string s, string t) {
        // sorted, then list of strings with that anagram
        //std::unordered_map<std::string, std::vector<std::string>> groups;

        // sort both strings
        //std::string sSorted = std::sort(s.begin(), s.end());
        //std::string tSorted = std::sort(t.being(), t.end());

        // store string, then a list of the characters + frequency?
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
