package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Returns: True
 * Example 2:
 *
 * Input: 14
 * Returns: False
 */
public class _367_ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {

        int pos = -1;
        int start = 1;
        int end = num;
        while(start <= end){
            int mid = start + (end - start) / 2;
            long fMid = mid * (long )mid;
            if(fMid <= num){
                pos = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return pos * pos == num;
    }
}
