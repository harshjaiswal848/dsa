class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int maxLength = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int num : set){
            if(!set.contains(num-1)){
                int currNum = num;
                int currLen = 1;
                while(set.contains(currNum+1)){
                    currLen++;
                    currNum++;
                }
                maxLength = Math.max(maxLength, currLen);
            }
        }
        return maxLength;

    }
}