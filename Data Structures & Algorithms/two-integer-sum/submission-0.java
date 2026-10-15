class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sum1 = {};
        // i needs to wait for all j's
        // Move i to the right
        for (int i = 0; i < nums.length; i++) {
            // Move j to the left
            for (int j = nums.length - 1; j > i; j--) {
                // Check, is this i + this j = target? no?
                // If no: move to next j, when all j's are done move i.
                if (nums[i] + nums[j] == target) {
                int[] sum = {i, j};
                return sum;
                }
            }
        }
        return sum1;
    }
}
