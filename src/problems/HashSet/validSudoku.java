package HashSet;

import java.util.HashSet;
/*
* 超级nb的 hashset
* */
public class validSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hs = new HashSet<String>();
        for(int i = 0 ;i < 9;i ++)
            for(int j = 0 ; j < 9 ;j ++){
                if(board[i][j]!='.')
                    if(!hs.add(board[i][j] +"in row" + i)||!hs.add(board[i][j] +"in col" + j)||!hs.add(board[i][j] +"in block" + i/3 + j /3))
                        return false;
            }
        return true;
    }
}
