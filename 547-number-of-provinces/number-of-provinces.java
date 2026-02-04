class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                provinces++;
                bfs(i, isConnected, visited);
            }
        }
        return provinces;
    }
    private void bfs(int src, int[][] isConnected, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;

        while(!q.isEmpty()){
            int city = q.poll();
            for(int i = 0 ; i < isConnected.length; i++){
                if(isConnected[city][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}