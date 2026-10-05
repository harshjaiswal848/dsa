class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int [m][n];
        return countPath(0, 0, m, n, dp);
    }
    private int countPath(int i, int j, int m, int n, int dp[][]){
        // base case
        if(i >= m || j >= n){
            return 0;
        }
        if(i == m-1 || j == n-1){
            return 1;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int right = countPath(i, j+1, m, n, dp);
        int down = countPath(i+1, j, m, n, dp);
        dp[i][j] = right  + down;
        return dp[i][j];
    }
}