package Facebook;

/**
 * @Author : Yutong Jin
 * @date : 8/1/18
 * @Description :
 * bfs超内存容量所以用dfs；
 */
public class _200_TD {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;

        boolean [][]visited = new boolean[row][col];
        int  result = 0;
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ;j ++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(i,j,visited,grid);
                    result++;

                }
            }
        }
        return result;
    }
    private void dfs(int i , int j , boolean[][] visited,char[][]grid){
        int row = grid.length;
        int col = grid[0].length;

        visited[i][j] = true;

        int [][] newPos = new int[][]{{i-1, j},{i+1, j},{i, j - 1},{i, j + 1}};
        for(int[] nextPos : newPos){
            if(nextPos[0] >= 0 && nextPos[0] <= row - 1 && nextPos[1] >= 0 && nextPos[1] <= col -1 && !visited[nextPos[0]][nextPos[1]] && grid[nextPos[0]][nextPos[1]] == '1'){
                dfs(nextPos[0] ,nextPos[1],visited,grid);
            }
        }
    }
}
