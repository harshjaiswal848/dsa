class Solution {
    public int swimInWater(int[][] grid) {
        int n =grid.length;
        boolean[][]visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{grid[0][0],0,0});
        visited[0][0] = true;
        int[][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int result = 0;

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int height = curr[0];
            int r = curr[1];
            int c = curr[2];

            result = Math.max(result, height);
            if(r == n-1 && c == n-1) return result;
            for(int[] dir:dirs){
                int nr = r+dir[0];
                int nc = c+dir[1];

                if(nr >= 0&& nr<n && nc>=0 && nc < n && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    pq.add(new int[]{grid[nr][nc],nr,nc});
                }
            }    
        }
        return -1;
    }
}