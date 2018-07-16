package NewSoftValley.Xian;

import java.util.TreeMap;

/*
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :
Alice has a hand of cards, given as an array of integers.

Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.

Return true if and only if she can.



Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
Example 2:

Input: hand = [1,2,3,4,5], W = 4
Output: false
Explanation: Alice's hand can't be rearranged into groups of 4.
*/
public class _846_HandofStraights {
public boolean isNStraightHand(int[] hand, int W) {
if(hand.length % W != 0)
return false;
int group = hand.length / W;
TreeMap<Integer,Integer> ts = new TreeMap<>();
for(int i : hand){
ts.put(i,ts.getOrDefault(i,0) + 1);
}

for(int j = 0 ; j < group; j++){
// 直到找到value 不为 0的entry进行搜索
while(ts.firstEntry().getValue() == 0)
ts.remove(ts.firstEntry().getKey());
int tmp = ts.firstEntry().getKey();
for(int i = 0 ; i < W ;i++){
// 找不到key或者其value 已经被之前的搜索过程设置为0
if(!ts.containsKey(tmp) || ts.get(tmp) == 0)
return false;
//找到后减1
ts.put(tmp,ts.get(tmp) - 1);
//更新我们要找的key
tmp++;
}
}
return true;
}
}
