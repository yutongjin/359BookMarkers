package DFS;



public class SurrendedRegion {
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0 )
            return;

        for(int i = 0 ; i < board[0].length; i ++){
            if(board[0][i] == 'O')
                dfs(0,i,board);
            if(board[board.length - 1][i] == 'O')
                dfs(board.length - 1 ,i, board);
        }
        for(int i = 0 ; i < board.length; i ++){
            if(board[i][0] == 'O')
                dfs(i,0,board);
            if(board[i][board[0].length - 1] == 'O')
                dfs(i,board[0].length - 1 , board);
        }

        for(int i = 0 ;i < board.length ; i ++)
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == 'T')
                    board[i][j] = 'O';
            }
    }
    private void dfs(int i , int j , char[][] board){
        if(i < 0 || i > board.length - 1|| j < 0 || j > board[0].length - 1 || board[i][j] != 'O')
            return ;
        if(board[i][j] == 'O')
            board[i][j] = 'T';
        dfs(i + 1 , j ,board);
        dfs(i - 1 , j ,board);
        dfs(i , j + 1,board);
        dfs(i, j - 1,board);

    }
}
