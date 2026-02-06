class Solution {
    int[][] grid;
    int rows, cols;

    public int numEnclaves(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;

        // eliminate land connected to border
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if ((r == 0 || c == 0 || r == rows - 1 || c == cols - 1)
                        && grid[r][c] == 1) {
                    dfs(r, c);
                }
            }
        }

        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 0) {
            return;
        }

        grid[r][c] = 0;

        dfs(r, c + 1);
        dfs(r, c - 1);
        dfs(r + 1, c);
        dfs(r - 1, c);
    }
}
