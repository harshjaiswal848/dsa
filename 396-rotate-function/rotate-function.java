class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0, F = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            F += i * nums[i];
        }

        int max = F;

        for (int i = 1; i < n; i++) {
            F += sum - n * nums[n - i];
            max = Math.max(max, F);
        }

        return max;
    }
}