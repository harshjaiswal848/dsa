class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int prevIndex = stack.pop();
                ans[prevIndex] = i-prevIndex;

            }
            stack.push(i);
        }
        return ans;
    }
}