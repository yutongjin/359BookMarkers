package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 */
public class _38_CountAndSay {
    public String countAndSay(int n) {
        if(n == 0)
            return "";
        if(n == 1)
            return "1";
        StringBuilder sb = new StringBuilder("1");
        for(int i = 1;i < n ; i ++){
            String tmp = new String(sb.toString());
            sb.delete(0,sb.length());
            int count = 1;
            for(int j = 1 ; j < tmp.length() ; j++){
                if(tmp.charAt(j) == tmp.charAt(j - 1 )){
                    count++;
                }
                else {
                    sb.append(count);
                    sb.append(tmp.charAt(j - 1 ));
                    count = 1;
                }

            }
            sb.append(count);
            sb.append(tmp.charAt(tmp.length() - 1 ));

        }
        return sb.toString();
    }
}
