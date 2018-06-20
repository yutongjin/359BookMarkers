package problems.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 6/19/18
 * @Description :
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.
 *
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.
 *
 * Example:
 * Input: [[1,2], [3], [3], []]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: The graph looks like this:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * Note:
 *
 * The number of nodes in the graph will be in the range [2, 15].
 * You can print different paths in any order, but you should keep the order of nodes inside one path.
 */
public class AllPathsFromSourcetoTarget
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> res = new ArrayList<>();
            if(graph.length == 0)
                return  res;
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(0);
            dfs(0,graph,tmp,res);
            return res;

        }
        private void dfs(int index , int[][] g , List<Integer> tmp, List<List<Integer>> res){
            if(!tmp.isEmpty() && tmp.get(tmp.size() - 1) == g.length - 1  ){
                res.add(new ArrayList<Integer>(tmp));
                return ;
            }
            for(int i = 0; i < g[index].length ; i++){
                tmp.add(g[index][i]);
                dfs(g[index][i],g,tmp,res);
                tmp.remove(tmp.size() - 1 );
            }
        }
}
