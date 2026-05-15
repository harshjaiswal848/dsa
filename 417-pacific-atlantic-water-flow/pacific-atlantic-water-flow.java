class Solution {

    int rows, cols;

    int directions[][] = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };

    public void dfs(int [][] heights,
                    boolean [][] visited,
                    int row,
                    int col){

        visited[row][col] = true;

        for(int dir[] : directions){

            int newRow = row + dir[0];
            int newCols = col + dir[1];

            // corrected boundary check
            if(newRow < 0 || newCols < 0 ||
               newRow >= rows || newCols >= cols){

                continue;
            }

            if(visited[newRow][newCols]){
                continue;
            }

            if(heights[newRow][newCols] <
               heights[row][col]){

                continue;
            }

            dfs(heights, visited, newRow, newCols);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int i = 0; i < rows; i++){

            dfs(heights, pacific, i, 0);

            dfs(heights, atlantic, i, cols - 1);
        }

        for(int j = 0; j < cols; j++){

            dfs(heights, pacific, 0, j);

            dfs(heights, atlantic, rows - 1, j);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < rows; i++){

            for(int j = 0; j < cols; j++){

                if(pacific[i][j] &&
                   atlantic[i][j]){

                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }
}