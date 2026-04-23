class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        //add edge 
        for(int []e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean visited[] = new boolean[n];
        return dfs(source, destination, adj, visited);
    }
    private boolean dfs(int src, int dest, ArrayList<ArrayList<Integer>> adj, boolean [] visited){
        if(src == dest){
            return true;
        }
        visited[src] = true;
        for(int neighbour:adj.get(src)){
            if(!visited[neighbour]){
                if(dfs(neighbour, dest, adj, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}