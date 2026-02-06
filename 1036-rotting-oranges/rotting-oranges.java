class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int mint = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()&&fresh >0){
            int size = q.size();
            mint++;

            for(int k=0;k<size;k++){
                int curr[] = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int[] d : dir){
                    int nr =r+d[0];
                    int nc =c+d[1];

                    if(nr >=0 && nc >=0 && nr< rows && nc <cols &&grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
        return fresh==0?mint : -1;
    }
}