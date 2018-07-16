package problems.BitOp;

/**
 * @Author : Yutong Jin
 * @date : 6/21/18
 * @Description :
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Now your job is to find the total Hamming distance between all pairs of the given numbers.

Example:
Input: 4, 14, 2

Output: 6

Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case). So the answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
Note:
Elements of the given array are in the range of 0 to 10^9
Length of the array will not exceed 10^4.

 */

/*
*  public int totalHammingDistance(int[] nums) {
        int res = 0 ;
        int n = nums.length;
        int [] z = new int [32];

        for(int i = 0 ; i < 32 ; i ++){
            for(int j = 0 ; j < n ; j++){
               if((nums[j] & 1) == 0){
                   z[i] ++;
               }

                nums[j] >>>= 1;
            }
            res += ( n - z[i])* z[i];
        }

        return res;
    }
   */
//我代码的问题： 改变了原来的数组；
public class totalhammingDistance {
    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int j=0;j<32;j++) {
            int bitCount = 0;
            for (int i=0;i<n;i++)
                bitCount += (nums[i] >> j) & 1;
            total += bitCount*(n - bitCount);
        }
        return total;
    }
}
