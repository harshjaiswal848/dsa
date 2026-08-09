class Solution {
    public int sumFourDivisors(int[] nums) {
        
        int temp =0;
        for (int num : nums){
            int count = 0;
            int ans = 0;
            for(int i=1; i<= num; i++){
                if(num%i == 0){
                    ans += i;
                    count++;
                    if(count > 4){ 
                        ans = 0;
                        break;
                    }
                }
            }
            if(count == 4){
                temp += ans;
            }
            

        }
        return temp;
    }
}