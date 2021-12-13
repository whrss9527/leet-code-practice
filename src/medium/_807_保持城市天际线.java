package medium;

public class _807_保持城市天际线 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        // 获取长宽
        int n = grid.length, m = grid[0].length;
        // 创建两个数组，记录每行每列的最大值
        int[] r = new int[n], c = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                r[i] = Math.max(r[i], grid[i][j]);
                c[j] = Math.max(c[j], grid[i][j]);
            }
        }
        int ans = 0;
        // 遍历所有节点，拿到该节点横向纵向最大值中的小者， 减去当前节点就是 在不影响天际线的情况下，该建筑能增加的高度
        // 累加
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += Math.min(r[i], c[j]) - grid[i][j];
            }
        }
        return ans;
    }

}
