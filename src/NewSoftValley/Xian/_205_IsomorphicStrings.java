package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class _205_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        return mappable(s,t) && mappable(t,s);
    }
    private boolean mappable(String s ,String t){
        if(s.length() ==0 )

            return true;
        int [] c = new int[256];
        for(int i = 0 ; i < s.length() ; i++){
            char cS = s.charAt(i);
            char cT = t.charAt(i);
            if(c[cS] != 0 ){
                if(c[cS] != cT)
                    return false;

            }
            else c[cS] = cT;
        }
        return true;
    }
}
