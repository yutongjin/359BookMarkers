package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //1 计算每个课程多需要的入度，放在一位数组degree[];
        int [] degree = new int [numCourses];
        for(int i = 0 ;i < prerequisites.length ; i++){
            degree[prerequisites[i][0]]++;
        }

        //2 计算每门课可以帮助减少哪门课的入度，创建一个hashMap ,注意一门课可以减少多个课程的入度所以value是一个arraylist
        HashMap<Integer,ArrayList<Integer>> hs = new HashMap<Integer,ArrayList<Integer>>();

        for(int i = 0 ;i < prerequisites.length ; i++){

            if(!hs.containsKey(prerequisites[i][1])){
                //   ArrayList<Integer> list = new ArrayList<Integer>(prerequisites[i][0]);
                // list.add(prerequisites[i][0]);
                hs.put(prerequisites[i][1],new ArrayList<Integer>(prerequisites[i][0]));
            }
            else hs.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        //3 准备bfs，先把基础课加入queue，即入度为0 的课。
        //tip：queue 是个抽象接口，不可以被实化，所以用linkedlist
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < degree.length ; i++){
            if(degree[i] == 0)
                q.offer(i);
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size; i ++){
                int tmp = q.poll();

                for(int j = 0;hs.get(tmp) != null &&j < hs.get(tmp).size() ; j++){ // 判断非空很关键，有的课不是任何课的基础课，一定是空集
                    degree[hs.get(tmp).get(j)]--;
                    if(degree[hs.get(tmp).get(j)] == 0)
                        q.offer(hs.get(tmp).get(j));
                }
            }//for size
        }//while

        //4 final check
        for(int i = 0 ; i < numCourses ;i ++){
            if(degree[i] > 0)
                return false;
        }//
        return true;

    }
}
