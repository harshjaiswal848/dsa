class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int n= nums[nums.length-1];
        if(nums.length != n+1){
            return false;
        }

        for(int i=0; i<n-1;i++){
            if(nums[i] != i+1){
                return false;
            }
        }
        return nums[n-1]==n && nums[n]==n;
    }
}