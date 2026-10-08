class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int maxLength = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int currentNum = num;
                int currLen = 1;
                while(set.contains(currentNum+1)){
                    currLen++;
                    currentNum++;
                }
                maxLength = Math.max(maxLength, currLen);
            }
        }
        return maxLength;
    }
}