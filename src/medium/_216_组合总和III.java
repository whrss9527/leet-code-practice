package medium;

import java.util.ArrayList;
import java.util.List;

public class _216_组合总和III {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1, 9, k, n);
        return ans;
    }

    // 深度优先，回溯
    public void dfs(int cur, int n, int k, int sum) {
        // 和超出去了 或者 元素个数超了
        if (temp.size() + (n - cur + 1) < k || temp.size() > k) {
            return;
        }
        if (temp.size() == k) {
            int tempSum = 0;
            for (int num : temp) {
                tempSum += num;
            }
            if (tempSum == sum) {
                ans.add(new ArrayList<Integer>(temp));
                return;
            }
        }
        temp.add(cur);
        dfs(cur + 1, n, k, sum);
        // 如果dfs停止，则表示可能数字个数超了，或者符合条件了，则移除最后一个元素，继续dfs
        temp.remove(temp.size() - 1);
        // 如果是之前的符合条件了，那么这里也会直接返回 两遍确认，
        dfs(cur + 1, n, k, sum);
    }
}
