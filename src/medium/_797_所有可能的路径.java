package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/***
 * 797. 所有可能的路径
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 *
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
 *
 * 译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * 示例 2：
 *
 *
 *
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * 示例 3：
 *
 * 输入：graph = [[1],[]]
 * 输出：[[0,1]]
 * 示例 4：
 *
 * 输入：graph = [[1,2,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,2,3],[0,3]]
 * 示例 5：
 *
 * 输入：graph = [[1,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,3]]
 *
 *
 * 提示：
 *
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i（即，不存在自环）
 * graph[i] 中的所有元素 互不相同
 * 保证输入为 有向无环图（DAG）
 */
public class _797_所有可能的路径 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Deque<Integer> stack = new ArrayDeque<Integer>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    public void dfs(int[][] graph, int x, int n) {
        // 每次检测到有元素 = length -1  该元素就是走到了尽头，就将结果加入到返回的list中
        if (x == n) {
            ans.add(new ArrayList<Integer>(stack));
            return;
        }
        // 深度优先
        /***
         * 假设 { [1,2] [3] [3] [] }
         * 表示0->1, 0->2 , 1->3, 2->3
         * 这里从第一个[1,2]开始，将下标0 存入栈，然后就会顺序遍历下标为0的这个数组中的[1,2]两个下标对应的元素，下标1中存放的是3，3=length-1，到达了尽头，将结果存入返回值
         * 第一轮深度优先遍历结束，退回上一次分支继续执行
         * 下标2中存放的是3， 3=length-1，到达了尽头，将结果存入返回值。
         *
         * 这个例子中的元素较少，元素越多越能够清楚理解这个解法。（如长度为5的话，会继续遍历下标为3的元素，遍历到value=4就加入返回值。）
         */
        for (int y : graph[x]) {
            // 末尾插入元素 将该
            stack.offerLast(y);
            dfs(graph, y, n);
            // 删除队尾元素
            stack.pollLast();
        }
    }
}
