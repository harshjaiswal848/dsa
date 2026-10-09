class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for(int right =0; right < n; right++){
            sum += nums[right];
            while(sum >= target){
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        if(minLength == Integer.MAX_VALUE){
            return 0;
        }
        return minLength;
    }
}