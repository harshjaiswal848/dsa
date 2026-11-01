class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        for(int i=0; i<n; i++){
            min = Math.min(min, nums[i]);
        }
        int moves = 0;
        for(int i=0;i<n;i++){
            moves += nums[i] - min;
        }
        return moves;
    }
}