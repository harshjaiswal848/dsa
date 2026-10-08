class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);

        }
        int maxFreq = 0;
        for(int freq : map.values()){
            maxFreq = Math.max(maxFreq, freq);
        }
        int ans = 0;
        for(int freq : map.values()){
            if(freq == maxFreq){
                ans += freq;
            }
        }
        return ans;
    }
}