class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if(n < 3){
            return 0;
        }
        int maxLength = 0;
        int i =1;
        while(i < n-1){
            //finding peak
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                //now find left
                int left = i;
                while(left > 0 && arr[left] > arr[left-1]){
                    left--;
                }
                //now find right
                int right = i;
                while(right < n-1 && arr[right] > arr[right+1]){
                    right++;
                }

                int length = right - left + 1;
                maxLength = Math.max(maxLength, length);
                i = right;
            }
            else{
                i++;
            }
        }
        return maxLength;
    }
}