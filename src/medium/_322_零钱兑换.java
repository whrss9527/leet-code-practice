package medium;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *  
 * <p>
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _322_零钱兑换 {
    /**
     * v[i]:代表每种硬币的价值
     * x[i]:代表每种硬币拿的个数，0<=x[i]<=amount/v[i]
     * 所求问题可以归纳为：
     * 在满足：amount=v1x1+v2x2+v3x3+...+vnxn 的条件下
     * 求： target=min{x1+x2+x3+....xn}
     * 最简单的一种思路就是把所有{xi}的组合全部拿出来，然后让target最小即可，利用递归就可以解决问题，但是时间复杂度会很高，但是如果有好的剪枝策略，也可以使用
     * 另外一种方法就是常规的动态规划，利用一个amout+1长度的dp数组，记录每一个状态的最优解，过程见程序和注释
     *
     * @param coins
     * @param amount
     * @return (动态规划递归解释)
     * 题目求的值为 f(11)，第一次选择硬币时我们有三种选择。
     * <p>
     * 假设我们取面额为 1 的硬币，那么接下来需要凑齐的总金额变为 11 - 1 = 10，即 f(11) = f(10) + 1，这里的 +1 就是我们取出的面额为 1 的硬币。
     * <p>
     * 同理，如果取面额为 2 或面额为 5 的硬币可以得到：
     * <p>
     * f(11) = f(9) + 1
     * f(11) = f(6) + 1
     * 所以：
     * <p>
     * f(11) = min(f(10), f(9), f(6)) + 1
     **/
    public static int coinChange(int[] coins, int amount) {
        // 最大不超过金额+1 （因为钱最少是1块）
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        // 双层for 计算出从1块到amount块每一位需要的最少钱币数
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // 判断下一个金币额度是否比要计算的amount小，小
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


//    public static void main(String[] args) {
//        int[] a = {1, 2, 3};
//        System.out.println(coinChange(a, 10));
//    }
}
