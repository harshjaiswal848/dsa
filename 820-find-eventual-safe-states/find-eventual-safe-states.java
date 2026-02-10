class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n =graph.length;
        int state[] =  new int[n];

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(isSafe(i,graph,state)){
                ans.add(i);
            }
        }
        return ans;
    }
    private boolean isSafe(int node, int[][]graph, int []state){
        if(state[node]!=0) return state[node] == 2;
        state[node] =1;
        for(int next:graph[node]){
            if(!isSafe(next,graph,state))return false;
        }
        state[node] =2;
        return true;
    }
}