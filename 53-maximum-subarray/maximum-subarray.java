class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int currentSum = nums[0];
        for(int i=1; i<n;i++){
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            max = Math.max(max, currentSum);

        }
        return max;
    }
}