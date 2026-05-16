class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left =0;
        int right = 0;

        for(int weight : weights){
            left = Math.max(left, weight);
            right += weight;
        }
        while(left < right){
            int mid = left + ( right - left )/2;
            int daysNeeded = 1;
            int currentLoad = 0;

            for(int weight: weights){
                if(currentLoad + weight > mid){
                    daysNeeded ++;
                    currentLoad = 0;
                }
                currentLoad += weight;
            }
            if(daysNeeded <= days){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}