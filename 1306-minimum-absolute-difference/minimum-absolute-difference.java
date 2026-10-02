class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i<n-1;i++){
            int diff = Math.abs(arr[i] - arr[i+1]);
            if(diff < minDiff){
                minDiff = diff;
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n-1;i++){
            int diff = Math.abs(arr[i] - arr[i+1]);
            if(diff == minDiff){
                ans.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return ans;
        
    }
}