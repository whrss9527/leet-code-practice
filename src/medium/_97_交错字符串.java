package medium;

public class _97_交错字符串 {
    public boolean isInterleave(String s1, String s2, String s3) {
        // 拿长度
        int n = s1.length(), m = s2.length(), t = s3.length();
        // 长度相加不同直接false
        if (n + m != t) {
            return false;
        }
        // 使用一个二维数组
        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;
        // 三个指针 ===> i、j记录s1、s2， p记录s3
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[n][m];
    }

}
