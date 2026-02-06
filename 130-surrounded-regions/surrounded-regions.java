class Solution {
    int rows, cols;
    public void solve(char[][] board) {
        if(board.length == 0) return;
        rows = board.length;
        cols = board[0].length;

        for(int i=0;i<rows;i++){
            if(board[i][0]=='O' ){
                dfs(board,i,0);
            }
            if(board[i][cols-1] == 'O'){
                dfs(board,i,cols-1);
            }
        }
        for(int j=0;j<cols;j++){
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[rows - 1][j] == 'O'){
                dfs(board, rows - 1, j);
            }
        }
        //check it is surrounded
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j] == '#'){
                    board[i][j]='O';
                }
            }
        }
    }
    void dfs(char[][]board, int r, int c){
        if(r<0 || c<0 || r >= rows || c >=cols|| board[r][c] != 'O') return;
        board[r][c] ='#';

        dfs(board, r+1,c);
        dfs(board, r-1,c);
        dfs(board, r,c+1);
        dfs(board, r,c-1);
    }
}