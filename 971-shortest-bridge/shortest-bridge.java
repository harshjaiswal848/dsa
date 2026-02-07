class Solution {
    int rows, cols;
    int [][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int shortestBridge(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean found = false;

        for(int i=0;i<rows&&!found;i++){
            for(int j=0;j<cols &&!found;j++){
                if(grid[i][j] == 1){
                    dfs(grid,i,j,q);
                    found =true;
                }
            }
        }
        //bfs
        int level =0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k=0;k<size;k++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int []d: dir){
                    int nr = r+d[0];
                    int nc = c+d[1];

                    if(nr >=0 && nc >= 0 && nr < rows && nc < cols){
                        if(grid[nr][nc] == 1){
                            return level;
                        }
                        if(grid[nr][nc] == 0){
                            grid[nr][nc] = -1;
                            q.add(new int []{nr,nc});
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
    void dfs(int[][] grid, int r, int c, Queue<int[]> q) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != 1) {
            return;
        }

        grid[r][c] = -1;
        q.add(new int[]{r, c});

        for (int[] d : dir) {
            dfs(grid, r + d[0], c + d[1], q);
        }
    }
}