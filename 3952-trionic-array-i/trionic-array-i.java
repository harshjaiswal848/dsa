class Solution {
    boolean check(int nums[], int p, int q){
        int n =nums.length;
        for(int i=0; i< p; i++){
            if(nums[i]>=nums[i+1]){
                return false;
            }
        }
        for(int i=p; i<q; i++){
            if(nums[i]<=nums[i+1]){
                return false;
            }
        }
        for(int i=q;i < n-1; i++){
            if(nums[i] >= nums[i+1]){
                return false;
            }
        }
        return true;
    }
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if(n <4){
            return false;
        }
        for(int i=1;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                if(check(nums,i,j)){
                    return true;
                }
            }
        }
        return false; 
    }
    
}