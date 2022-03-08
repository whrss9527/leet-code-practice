package medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 先去重
        Set<String> wordDictSet = new HashSet(wordDict);
        // 依次后推， 看是否能够从0 拼接到最后一位， 注意：中间有一些索引是直接跳过的
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        // i 从 1 开始
        // j 从 0 开始
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // 如果从0到j 符合规则，那么再从j开始比对 比对到i
                // j到i符合条件，则将0到下标i标志设置为true
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
