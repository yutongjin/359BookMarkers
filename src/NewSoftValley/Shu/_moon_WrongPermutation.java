package NewSoftValley.Shu;

import java.lang.invoke.WrongMethodTypeException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 7/14/18
 * @Description :
 */
public class _moon_WrongPermutation {
    int size = 0;
    public List<List<Integer>> wrongPermutation(int n){
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0)
            return res;
        helper(res,0,new ArrayList<Integer>(),n);
        return res;
    }
    private void helper( List<List<Integer>> res, int index,List<Integer> tmp,int n){
        if(tmp.size() == n){
            res.add(new ArrayList<>(tmp));
            size ++;
            return ;
        }
        for(int i = 0; i < n ; i++){
            if(i != index && !tmp.contains(i)){
                tmp.add(i);
                helper(res,index + 1,tmp,n);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    public static void main(String [] args){
        _moon_WrongPermutation test = new _moon_WrongPermutation();
        List<List<Integer>> res = test.wrongPermutation(6);
        Iterator<List<Integer>> it = res.iterator();
        while(it.hasNext()){
            List<Integer> tmp= it.next();
            System.out.println(tmp);
        }
        System.out.println(test.size);
    }
}
