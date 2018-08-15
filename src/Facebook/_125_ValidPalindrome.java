package Facebook;

/**
 * @Author : Yutong Jin
 * @date : 8/10/18
 * @Description :
 */
public class _125_ValidPalindrome {
    public boolean isPalindrome(String ss) {
        if(ss.length() == 0)
            return true;
        int start = 0 ;
        int end = ss.length()- 1;
        String s = ss.toLowerCase();
        while(start < end){
            while(start < end && !((s.charAt(start) >= 'a' && s.charAt(start) <= 'z') || (s.charAt(start) >= '0' && s.charAt(start) <= '9'))){
                start ++;
            }
            while(start < end && !((s.charAt(end) >= 'a' && s.charAt(end) <= 'z') || (s.charAt(end) >= '0' && s.charAt(end) <= '9'))){
                end--;
            }
            int diff = (int) Math.abs(s.charAt(start) - s.charAt(end)) ;
            if(diff == 0 ){
                start ++;
                end--;
            }
            else return false;

        }
        return true;
    }
}
