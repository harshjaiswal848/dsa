class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int curr = nums[i];
            if(map.containsKey(curr)){
                int prevIndex = map.get(curr);
                if(Math.abs(i-prevIndex) <= k){
                    return true;
                }
                else{
                    map.put(curr, i);
                }
            }
            else{
                map.put(curr, i);
            }
        }
        return false;
    }
    
}