class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        // int, bool saying if it's in here already
        std::unordered_set<int> dupes;
        for (int i = 0; i < nums.size(); i++) {
            if (dupes.contains(nums[i])) {
                return true;
            }
            if (!dupes.contains(nums[i])) {
                dupes.insert(nums[i]);
            }
        }
        return false;
    }
};