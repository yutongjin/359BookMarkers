package BitOp;

/**
 * @Author : Yutong Jin
 * @date : 6/15/18
 * @Description :Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 *
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 */
public class numberComplement {
    public int findComplement(int num) {
        int n = 0;
        while(Math.pow(2,n) <= num){
            n++;
        }
        return (int )(Math.pow(2,n )- 1) - num;
    }
}
/*位操作笨办法
*   public int findComplement(int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        num = ~num;
        return num & mask;
    }*/