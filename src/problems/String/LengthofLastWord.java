package String;

/*
* 易错点：  String : s.length()方法
*           数组： int []    nums.length;
*           list : l.size();
* */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        int res = 0 ;
        for(int i = s.length() - 1; i >= 0 ; i--){
            if(s.charAt(i) == ' ' && res == 0)
                continue;
            else if(s.charAt(i) == ' ' && res != 0)
                return res;
            else
                res++;
        }
        return res;
    }
}
