package problems.DFS;

/**
 * @Author : Yutong Jin
 * @date : 6/21/18
 * @Description :Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 * Example:
 * X..X
 * ...X
 * ...X
 * In the above board there are 2 battleships.
 * Invalid Example:
 * ...X
 * XXXX
 * ...X
 * This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
 * Follow up:
 * Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?
 */
public class battleShip {
    public int countBattleships(char[][] board) {
        if(board == null || board.length == 0 )
            return 0;
        int row = board.length;
        int col = board[0].length;
        int res = 0;
        boolean [][] visited = new boolean [row][col];
        for(int i = 0 ; i < row ; i ++){
            for (int j = 0 ; j < col ; j ++){
                if(!visited[i][j] && board[i][j] == 'X'){
                    dfs1(i,j,board,visited);
                    dfs2(i,j,board,visited);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs1(int i , int j , char[][] board,boolean [][] visited ){
        if(i < 0 || i > board.length -1 || j < 0 || j > board[0].length|| board[i][j] == '.')
            return ;
        visited[i][j] = true;
        dfs1(i + 1,j,board,visited);
    }
    private void dfs2(int i , int j , char[][] board,boolean [][] visited ){
        if(i < 0 || i > board.length -1 || j < 0 || j > board[0].length - 1 || board[i][j] == '.')
            return ;
        visited[i][j] = true;
        dfs2(i,j + 1,board,visited);
    }
}
