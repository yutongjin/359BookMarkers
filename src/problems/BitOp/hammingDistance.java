package problems.BitOp;

/**
 * @Author : Yutong Jin
 * @date : 6/21/18
 * @Description :
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
↑   ↑

The above arrows point to positions where the corresponding bits are different.
 */
public class hammingDistance {
    public int hammingDistance(int x, int y) {
        int i=x^y;
        int res = 0;
        for(int j = 0 ; j < 32; j++){
            res+= i & 1;
            i >>>= 1;
        }
        return res;
    }
}
