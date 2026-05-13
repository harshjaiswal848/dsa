class Solution {
    public int trap(int[] height) {
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int left = 0;
        int right =height.length-1;
        int res =0;

        while(left < right){
            leftMax=Math.max(leftMax, height[left]);
            rightMax=Math.max(rightMax, height[right]);

            res+= leftMax < rightMax ?
            leftMax-height[left++] : rightMax-height[right--];
        } 
        return res;
    }
}