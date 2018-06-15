package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class CousreScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> res = new ArrayList<>();
        int []degree = new int [numCourses];
        for(int i = 0 ; i < prerequisites.length ; i ++){
            degree[prerequisites[i][0]]++;
        }

        HashMap<Integer, ArrayList<Integer>> hs = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0 ; i < prerequisites.length ; i++){
            if(hs.containsKey(prerequisites[i][1]))
                hs.get(prerequisites[i][1]).add(prerequisites[i][0]);
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                hs.put(prerequisites[i][1],list);}
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0 ; i < numCourses; i ++){
            if(degree[i] == 0)
                q.offer(i);

        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i < size ; i ++){
                int tmp = q.poll();
                res.add(tmp);    //new
                ArrayList<Integer> al = hs.get(tmp);
                for(int j = 0 ; al!=null && j<al.size() ; j++){
                    if(--degree[al.get(j)] == 0)
                    {
                        q.offer(al.get(j));
                    }
                }
            }//for
        }//while

        for(int i = 0 ; i <numCourses ; i++){
            if(degree[i]!=0)
                return new int[0];
        }

        int[] ress = new int[res.size()];
        for(int i = 0 ; i < ress.length;i++){
            ress[i] = res.get(i);
        }
        return ress;
    }
}