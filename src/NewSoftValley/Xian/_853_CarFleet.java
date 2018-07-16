package NewSoftValley.Xian;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :N cars are going to the same destination along a one lane road.  The destination is target miles away.
 *
 * Each car i has a constant speed speed[i] (in miles per hour), and initial position position[i] miles towards the target along the road.
 *
 * A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.
 *
 * The distance between these two cars is ignored - they are assumed to have the same position.
 *
 * A car fleet is some non-empty set of cars driving at the same position and same speed.  Note that a single car is also a car fleet.
 *
 * If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
 *
 *
 * How many car fleets will arrive at the destination?
 *
 *
 *
 * Example 1:
 *
 * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * Output: 3
 * Explanation:
 * The cars starting at 10 and 8 become a fleet, meeting each other at 12.
 * The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
 * The cars starting at 5 and 3 become a fleet, meeting each other at 6.
 * Note that no other cars meet these fleets before the destination, so the answer is 3.
 *
 * Note:
 *
 * 0 <= N <= 10 ^ 4
 * 0 < target <= 10 ^ 6
 * 0 < speed[i] <= 10 ^ 6
 * 0 <= position[i] < target
 */
public class _853_CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {

        // 1 put info into car
        int n = speed.length;
        if(n ==0)
            return n;
        Car[] cars = new Car[n];
        for(int i = 0 ; i < n; i++){
            cars[i] = new Car(position[i],speed[i]);
        }
        Arrays.sort(cars,new Comparator<Car>(){
            @Override
            public int compare(Car o1,Car o2){
                return Integer.compare(o1.pos,o2.pos);
            }
        });

        Stack<Car> res = new Stack<>();
        int result = n;

        for(int i = 0 ; i < n ; i++){
            //要用是while 因为 stack里的车队 很可能被后面一个傻逼给拦住了，这时候前面车队都完蛋了
            while( !res.isEmpty() && (double)(target - cars[i].pos) / (double)cars[i].speed >= (double)(target -res.peek().pos) / (double)res.peek().speed){
                result--;
                res.pop();

            }
            res.push(cars[i]);
        }
        return result;

    }
    class Car{
        int pos;
        int speed;
        public Car(int pos,int speed){
            this.pos = pos;
            this.speed = speed;
        }
    }
}
