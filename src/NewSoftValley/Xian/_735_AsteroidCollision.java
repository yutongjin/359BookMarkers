package NewSoftValley.Xian;

import java.util.Stack;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 *
 * Example 1:
 * Input:
 * asteroids = [5, 10, -5]
 * Output: [5, 10]
 * Explanation:
 * The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
 * Example 2:
 * Input:
 * asteroids = [8, -8]
 * Output: []
 * Explanation:
 * The 8 and -8 collide exploding each other.
 * Example 3:
 * Input:
 * asteroids = [10, 2, -5]
 * Output: [10]
 * Explanation:
 * The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
 * Example 4:
 * Input:
 * asteroids = [-2, -1, 1, 2]
 * Output: [-2, -1, 1, 2]
 * Explanation:
 * The -2 and -1 are moving left, while the 1 and 2 are moving right.
 * Asteroids moving the same direction never meet, so no asteroids will meet each other.
 */
public class _735_AsteroidCollision {
    public int[] asteroidCollision(int[] a) {
        if(a.length == 0)
            return new int [0];
        Stack<Integer> s = new Stack<>();

        for(int ball : a){
            if(ball > 0 ){
                s.push(ball);
            }
            else {while( !s.isEmpty() && s.peek() > 0 && ball+ s.peek() < 0){
                s.pop();
            }


                if(s.isEmpty() || s.peek() < 0  ){
                    s.push(ball);
                }
                else  if(s.peek() > 0 && Math.abs(ball) == s.peek()){
                    s.pop();
                }
            }
        }
        int [] res = new int[s.size()];
        int i = 0;
        for(Integer b : s){
            res[i++] = b;
        }
        return res;
    }
}
