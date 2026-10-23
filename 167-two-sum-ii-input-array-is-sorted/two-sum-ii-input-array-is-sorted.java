class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n-1;
        for(int i=0;i<n;i++){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left+1, right+1};
            }
            if(sum > target){
                right--;

            }
            else{
                left++;
            }
        }
        return new int[]{-1,-1};
    }
}