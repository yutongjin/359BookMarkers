package problems.DP;

import java.util.ArrayList;

/**
 * @Author : Yutong Jin
 * @date : 6/19/18
 * @Description :Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 *
 * Follow up:
 *
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).®
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 * Credits:
 * Special thanks to @ syedee for adding this problem and creating all test cases.
 */
public class countingbits {
    public int[] countBits(int num) {
        int [] res = new int [num + 1 ];
        res[0] = 0;
        if(num == 0)
        {
            return res;
        }
        res[1] = 1 ;
        if(num == 1 ){

            return res;
        }
        int i = 2;
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        while( i <= num){
            int size = tmp.size();
            for(int j = 0 ; j < 2 * size ; j++){
                if(i > num  )
                    break;
                res[i] = tmp.get(j % size);

                if(j >= size){
                    res[i]++;
                    tmp.add(res[i]);
                }
                i++;
            }
        }
        return res;
    }
}
