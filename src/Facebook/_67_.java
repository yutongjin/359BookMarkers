package Facebook;

/**
 * @Author : Yutong Jin
 * @date : 7/30/18
 * @Description :
 * //没啥说的，注意进位法则，更新carry 的值
 */
public class _67_  implements  _67_Add_Binary{
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        char carry = '0';
        while(indexA >= 0 || indexB >= 0){
            char tmpA = indexA >= 0 ?a.charAt(indexA) : '0';
            char tmpB = indexB >= 0 ?b.charAt(indexB) : '0';

            if(tmpA == '1' && tmpB == '1'){
                sb.append(carry);
                carry = '1';

            }
            else if(tmpA == '0' && tmpB == '0'){
                sb.append(carry);
                carry = '0';
            }
            else  if(carry == '1'){
                carry = '1';
                sb.append(0 + "");
            }
            else if(carry != '1'){
                carry = '0';
                sb.append(1 + "");
            }
            indexA--;
            indexB--;
        }
        if(carry != '0')
            sb.append(carry);
        return sb.reverse().toString();
    }
}
