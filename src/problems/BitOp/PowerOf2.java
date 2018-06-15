package BitOp;

public class PowerOf2 {
    //sol 1 ： 计算1的个数。
    static public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        int ones = 0;
        for (int i = 1; i <= 32; ++i) {
            ones += n & 1;
            n = n >> 1;
        }
        return ones == 1;
    }
    //sol 2 ：设置flag，可以提前终止。
    static public boolean isPowerOfTwo2(int n) {
        if(n == 0 )
            return false;
        boolean res = false;
        while(n != 0){


            if(res && (n & 1) == 1)
                return false;
            if(!res && (n & 1) == 1)
                res = true;
            n = n >> 1;
        }
        return true;
    }

}
