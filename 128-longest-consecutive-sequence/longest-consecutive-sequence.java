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
                int currentNum = num;
                int currLen = 1;
                while(set.contains(currentNum + 1)){
                    currLen++;
                    currentNum ++;

                }
                maxLength = Math.max(maxLength, currLen);
            }
        }
        return maxLength;
    }

}