package problems.HashSet;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Yutong Jin
 * @date : 6/24/18
 * @Description :In a forest, each rabbit has some color. Some subset of rabbits (possibly all of them) tell you how many other rabbits have the same color as them. Those answers are placed in an array.
 *
 * Return the minimum number of rabbits that could be in the forest.
 *
 * Examples:
 * Input: answers = [1, 1, 2]
 * Output: 5
 * Explanation:
 * The two rabbits that answered "1" could both be the same color, say red.
 * The rabbit than answered "2" can't be red or the answers would be inconsistent.
 * Say the rabbit that answered "2" was blue.
 * Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
 * The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.
 *
 * Input: answers = [10, 10, 10]
 * Output: 11
 *
 * Input: answers = []
 * Output: 0
 */
public class NSV_781Rabbits_in_Forest {
    public int numRabbits(int[] answers) {
        int result = 0 ;
        Map<Integer,Integer> sumToAnswer = new HashMap<>();
        for(int answer : answers){
            int sum= answer + 1;
            if(sumToAnswer.containsKey(sum)){
                sumToAnswer.put(sum,sumToAnswer.get(sum) + 1);
            }
            else sumToAnswer.put(sum,1);
            if(sumToAnswer.get(sum) == sum){
                result+= sum;
                sumToAnswer.remove(sum);
            }
        }
        for(Map.Entry<Integer,Integer> entry : sumToAnswer.entrySet()){
            result += entry.getKey();
        }

        return result;
    }
}
