package medium;

import java.util.ArrayList;
import java.util.List;

public class _22_括号生成 {

    ArrayList[] cache = new ArrayList[100];
    // 递归 性能较差
    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<String>();
        // 递归开始
        if (n == 0) {
            ans.add("");
        } else {
            // (a)b 的原则
            // 递归调用 generate(i) 即可计算 a 的所有可能性
            // 递归调用 generate(n - i - 1) 即可计算 b 的所有可能性
            for (int c = 0; c < n; ++c) {
                for (String left: generate(c)) {
                    for (String right: generate(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }

    public List<String> generateParenthesis(int n) {
        return generate(n);
    }

}
