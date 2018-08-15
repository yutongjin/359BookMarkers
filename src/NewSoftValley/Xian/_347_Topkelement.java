package NewSoftValley.Xian;

import java.util.*;

/**
 * @Author : Yutong Jin
 * @date : 8/2/18
 * @Description :
 */
public class _347_Topkelement {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> minHeap=new PriorityQueue<>((a, b)->(a.getValue()-b.getValue()));
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(minHeap.size() < k)
                minHeap.add(entry);
            else if(minHeap.peek().getValue() < entry.getValue()){
                minHeap.poll();
                minHeap.add(entry);
            }

        }

        List<Integer> ret=new ArrayList<>();

        for(int j = 0 ; j < k; j++){

            ret.add(minHeap.poll().getKey());
        }

        return ret;
    }
}
