package BitOp;

public class Numberof1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;

        while(n != 0){
            res += (n & 1);
            n = n>>> 1;
        }
        return res;
    }
    //1、当移位的数是正数的时候，>> 和>>>效果都是一样的；
    //2、当移位的数是负数的时候，>>将二进制高位用1补上，而>>>将二进制高位用0补上，这就导致了>>>将负数的移位操作结果变成了正数（因为高位用0补上了）。
}
