package NewSoftValley.Xian;

import java.util.*;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 */
public class _692_TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String,Integer> hm = new HashMap<>();
        for(String word : words){
            if(!hm.containsKey(word) ){
                hm.put(word,1);
            }
            else hm.put(word,hm.get(word) + 1);
        }
        Comparator<Map.Entry<String,Integer>> comparator =  new Comparator(){
            @Override // tmd大写

            public int compare(Object oo1,Object oo2){
                Map.Entry<String,Integer> o1 = ( Map.Entry<String,Integer>) oo1;
                Map.Entry<String,Integer> o2 = ( Map.Entry<String,Integer>) oo2;
                int v1 = o1.getValue();
                int v2 = o2.getValue();
                String s1 = o1.getKey();
                String s2 = o2.getKey();
                return Integer.compare(v1,v2) != 0 ?Integer.compare(v1,v2) :s2.compareTo(s1);
            }
        };
        PriorityQueue<Map.Entry<String,Integer>> heap = new PriorityQueue<>(comparator);
        int count = 0 ;
        //把k个数先加进去，然后维持最小堆，循环不变量是遍历到的i个数里k个最大的值
        for(Map.Entry<String,Integer> entry : hm.entrySet()){
            if(count ++ < k)
                heap.add(entry);
            else {
                int compareRes = comparator.compare(entry,heap.peek());
                if(compareRes > 0){// 加入时的比较也要考虑 freq相同的情况
                    heap.poll();
                    heap.add(entry);
                }
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0 ; i < k ; i ++){
            res.add(0,heap.poll().getKey());//在0处加元素相当于倒序加
        }
        return res;
    }
}
