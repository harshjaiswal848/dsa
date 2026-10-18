class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int count =0;
        int index = 0;
        int res[] = new int[n];
        for(int i= 0;i<n;i++){
            if(nums[i] == 0){
                count++;
                continue;
            }
            res[index] = nums[i];
            index++;
        }
        while(count > 0){
            res[index] = 0;
            count--;
            index++;
        }
        for(int i=0; i<n;i++){
            nums[i] = res[i];
        }
    }
}