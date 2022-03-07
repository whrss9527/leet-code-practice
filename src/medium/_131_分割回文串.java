package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _131_分割回文串 {
    boolean[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }
        // 预处理， 从i到j是否是回文串
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {
        // 到头就返回一个答案
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        // 依旧双指针，i从0开始，j从i开始，i再从j+1开始。
        // 保证交替接力不重复
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                // 调用栈执行完，在执行下一dfs前，先把dfs清空
                ans.remove(ans.size() - 1);
            }
        }
    }

}
