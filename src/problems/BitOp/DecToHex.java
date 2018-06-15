package BitOp;

public class DecToHex {

    //经典位操作，可用于一切2的幂指数进制的转换。
    //注意string += "1" 和 string = string + 1不一样
    public String toHex(int num) {
        if(num == 0)
            return"0";

        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        String res = "";
        while(num != 0 ){
            res = map[(num & 15)] + res;
            num = num>>>4;
        }
        return res;

    }
}
