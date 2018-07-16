package NewSoftValley.Xian;

import java.util.Stack;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
public class _50_Pow {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        return pow(x,n);
    }

    private double pow(double x, long n){

        if(n < 0)
            return 1 / pow(x,-1 * n);

        Stack<Double> s = new Stack<>();
        while(n > 1){
            s.push(n %2 == 0 ? 1 : x);
            n /= 2;
        }
        double  res = x;
        while(!s.isEmpty()){
            res =res * res * s.pop();
        }
        return res;
    }
}
