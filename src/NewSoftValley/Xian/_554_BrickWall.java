package NewSoftValley.Xian;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.
 *
 * The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.
 *
 * If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
 *
 * You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.
 *
 * Example:
 * Input:
 * [[1,2,2,1],
 *  [3,1,2],
 *  [1,3,2],
 *  [2,4],
 *  [3,1,2],
 *  [1,3,1,1]]
 * Output: 2
 * Explanation:
 *
 * Note:
 * The width sum of bricks in different rows are the same and won't exceed INT_MAX.
 * The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.
 */
public class _554_BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        if(wall.size() == 0)
            return 0;
        int res = wall.size() ;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(List list : wall){
            int gap = 0;
            Iterator<Integer> it = list.iterator();
            while(it.hasNext()){
                gap += it.next();
                if(!it.hasNext())
                    break;
                if(!hm.containsKey(gap)){
                    hm.put(gap,1);
                }

                else hm.put(gap,hm.get(gap)+1);

            }

        }
        int wallSize = wall.size();
        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){

            res = Math.min(res,wallSize - entry.getValue());
        }
        return res;
    }
}
