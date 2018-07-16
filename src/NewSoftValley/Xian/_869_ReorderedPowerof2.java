package NewSoftValley.Xian;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 7/14/18
 * @Description :User Accepted: 1320
 * User Tried: 1605
 * Total Accepted: 1337
 * Total Submissions: 3088
 * Difficulty: Medium
 * Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.
 *
 * Return true if and only if we can do this in a way such that the resulting number is a power of 2.
 *
 *
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Example 2:
 *
 * Input: 10
 * Output: false
 * Example 3:
 *
 * Input: 16
 * Output: true
 * Example 4:
 *
 * Input: 24
 * Output: false
 * Example 5:
 *
 * Input: 46
 * Output: true
 */
public class _869_ReorderedPowerof2 { public boolean reorderedPowerOf2(int N) {
    List<int []> list = new ArrayList<>();
    int[] temp = new int[10];
    int [] arrayN = new int [10];
    for(int i = 0 ; i < 32; i++){
        int tmp = (int )Math.pow(2,i);
        while(tmp > 0){
            temp[tmp % 10] ++;
            tmp /= 10;
        }
        list.add(temp.clone());
        temp = new int [10];
    }

    while(N > 0){
        arrayN[N % 10] ++;
        N /= 10;
    }
    for(int i = 0 ; i < 32; i++){
        int[] tmp = list.get(i);
        for(int j = 0 ; j < 10 ; j ++){
            if(tmp[j] != arrayN[j])
                break;
            if(j == 9)
                return true;
        }
    }
    return false;
}
}
