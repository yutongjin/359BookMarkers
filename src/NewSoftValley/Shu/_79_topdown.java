package NewSoftValley.Shu;

import java.util.HashSet;

/**
 * @Author : Yutong Jin
 * @date : 7/27/18
 * @Description :
 */
public class _79_topdown implements _79_WordSearch{
    public boolean exist(char[][] board, String word) {
        boolean [] res = new boolean[1];
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length;j ++){
                if(board[i][j] == word.charAt(0)){
                    HashSet<Pos> path = new HashSet<>();
                    dfs(word,0,new Pos(i,j),board,res,path);
                    if(res[0])
                        return true;
                }
            }
        }
        return false;
    }
    private void dfs(String word,int index,Pos pos,char[][] board,boolean[] res,HashSet<Pos> path){
        //op at node
        path.add(pos);
        if(index == word.length() - 1){
            res[0] = true;
            return ;
        }
        //go down to children
        Pos[] newPos = new Pos[]{new Pos(pos._row + 1,pos._col),new Pos(pos._row,pos._col + 1),new Pos(pos._row,pos._col - 1),new Pos(pos._row - 1,pos._col)};
        for(Pos nextPos : newPos){
            if(nextPos._row >= 0&& nextPos._row <= board.length - 1&& nextPos._col >=0 && nextPos._col <= board[0].length - 1 && board[nextPos._row][nextPos._col] == word.charAt(index + 1) &&! path.contains(nextPos)){
                dfs(word,index + 1,nextPos,board,res,path);
            }
            if(res[0])
                break;
        }
        path.remove(pos);
        //go up to parent
    }
    class Pos{
        int _row;
        int _col;
        Pos(int row,int col){
            _row = row;
            _col = col;
        }
        @Override
        public boolean equals(Object that ){
            return that !=null && that instanceof Pos && ((Pos)that)._row == this._row && ((Pos)that)._col == this._col;
        }
        public int hashCode(){
            return 31 * _row + _col;
        }
    }
}
