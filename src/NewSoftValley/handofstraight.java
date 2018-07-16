package NewSoftValley;

import java.util.TreeMap;

/**
 * @Author : Yutong Jin
 * @date : 7/5/18
 * @Description :
 */
public class handofstraight {
    public boolean isNStraightHand(int[] hand, int W) {


        if(hand.length % W != 0)
            return false;
        int group = hand.length / W;

        TreeMap<Integer,Integer> ts = new TreeMap<>((o1, o2) ->(Integer.compare(o1,o2) ));
        for(int i : hand){
            if(ts.containsKey(i)){
                ts.put(i,ts.get(i) + 1);
            }
            else ts.put(i,1);
        }

        for(int j = 0 ; j < group; j++){
            while(ts.firstEntry().getValue() == 0)
                ts.remove(ts.firstEntry().getKey());
            int tmp = ts.firstEntry().getKey();
            System.out.print(tmp);
            for(int i = 0 ; i < W ;i++){
                if(!ts.containsKey(tmp) || ts.get(tmp) == 0)
                    return false;

                ts.put(tmp,ts.get(tmp) - 1);
             //   System.out.print(ts.firstEntry().getValue());
                tmp++;
            }
        }


        return true;
    }
    public static void main (String [] args){
        int [] nums = new int[]{1,2,3,6,2,3,4,7,8};
        System.out.print(new handofstraight().isNStraightHand(nums,3));
    }
}
