package Facebook;

/**
 * @Author : Yutong Jin
 * @date : 8/7/18
 * @Description :一遍过
 */
public class _680_ {
    public boolean validPalindrome(String s) {
        int p = 0;
        int q = s.length() - 1;
        while(p <= q){
            if(s.charAt(p) != s.charAt(q)){
                return isP( p+1,q,s) ||isP(p,q-1,s);
            }
            p++;
            q--;
        }
        return true;
    }
    private boolean isP(int start ,int end ,String s){

        while(start <= end){
            if(s.charAt(start)!= s.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}
