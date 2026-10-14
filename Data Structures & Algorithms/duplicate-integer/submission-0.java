class Solution {
    public boolean hasDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // check => i, e.g. 1
            int first = nums[i];
            
            // check up till index of i, so just before i
            for (int j = 0; j < i; j++) {
                int second = nums[j];
                if (second == first) {
                    return true;
                }
            }
            for (int j = i + 1; j < nums.length; j++) {
                int second = nums[j];
                if (first == second) {
                    return true;
                }
            }
        }
        return false;
    }
}