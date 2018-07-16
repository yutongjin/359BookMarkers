package NewSoftValley.Xian;

import java.util.Stack;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 * Corner Cases:
 *
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class _71_SimplifyPath {
    public String simplifyPath(String path) {
        if(path.length() == 0)
            return "";
        String[] pathArray = path.split("/");
        Stack<String> s = new Stack<>();
        for(String str : pathArray){
            if(str.equals("") || str.equals("."))
                continue;
            if(str.equals(".."))
            {
                if(!s.isEmpty())
                    s.pop();
            }
            else s.push(str);
        }
        StringBuilder sb = new StringBuilder();
        if(s.isEmpty())
            return "/";
        for(String str : s){
            sb.append("/").append(str);
        }
        return sb.toString();
    }
}
