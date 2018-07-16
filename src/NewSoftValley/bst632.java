package NewSoftValley;

import java.util.*;

/**
 * @Author : Yutong Jin
 * @date : 7/8/18
 * @Description :
 */
public class bst632 {
    public int[] smallestRange(List<List<Integer>> nums) {

        TreeSet<int []> ts = new TreeSet<>(new Comparator<int []>(){
            @Override
            public int compare(int [] o1, int [] o2){
                return Integer.compare(nums.get(o1[0]).get(o1[1]),nums.get(o2[0]).get(o2[1])) != 0?
                        Integer.compare(nums.get(o1[0]).get(o1[1]),nums.get(o2[0]).get(o2[1])) : Integer.compare(o1[0],o2[0]);

            }});
        int min = 100;
        for(int i = 0 ; i < nums.size(); i++){
            ts.add(new int[]{i,0});
            min = Math.min(nums.get(i).get(0),min);
            //System.out.println(ts.first()[0] +" " + ts.last()[0] + " ");
           System.out.println(nums.get(ts.first()[0]).get(ts.first()[1]) +" " + nums.get(ts.last()[0]).get(ts.last()[1])+ " ");
        }
        System.out.println( " min is "  + min);
        int[] res = new int[]{nums.get(ts.first()[0]).get(ts.first()[1]),nums.get(ts.last()[0]).get(ts.last()[1])};
        System.out.println(nums.get(ts.first()[0]).get(ts.first()[1]) + " "+nums.get(ts.last()[0]).get(ts.last()[1]));
        while(ts.size() == nums.size()) {

            int[] tmp = ts.pollFirst();
            int [] tmp2 = ts.last();
            System.out.println(  tmp[0] +" "+ tmp[1] +" "+nums.get(tmp[0]).get(tmp[1])+" ");
            System.out.println(  tmp2[0] +" "+ tmp2[1] +" "+nums.get(tmp2[0]).get(tmp2[1])+" ");
            if (tmp[1] + 1 < nums.get(tmp[0]).size())
                ts.add(new int[]{tmp[0], tmp[1] + 1});

            if (Math.abs(nums.get(ts.last()[0]).get(ts.last()[1]) - nums.get(ts.first()[0]).get(ts.first()[1])) <
                    Math.abs(res[1] - res[0]))
                res = new int[]{nums.get(ts.first()[0]).get(ts.first()[1]),
                        nums.get(ts.last()[0]).get(ts.last()[1])};
           // System.out.print(  res[0] +" "+ res[1]+" ");

        }
        return res;
        //数学归纳法推导
        //输入改成iterator
        // bst  nb
    }

    public static void main(String[] args){
        int [] a1 = new int[]{4,10,15,24,26};
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(4);
        l1.add(10);
        l1.add(15);
        l1.add(24);
        l1.add(26);
        list.add(l1);

        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(0);
        l2.add(9);
        l2.add(12);
        l2.add(20);

        list.add(l2);

        List<Integer> l3 = new ArrayList<Integer>();
        l3.add(5);
        l3.add(8);
        l3.add(22);
        l3.add(30);
        l3.add(50);
        list.add(l3);
int []res =  new bst632().smallestRange(list);
        System.out.print(  res[0] +" "+ res[1]);
    }
}
