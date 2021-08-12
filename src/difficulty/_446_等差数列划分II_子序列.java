package difficulty;

import java.util.HashMap;
import java.util.Map;

/***
 * 446. 等差数列划分 II - 子序列
 * 给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。
 *
 * 如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。
 *
 * 例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。
 * 再例如，[1, 1, 2, 5, 7] 不是等差序列。
 * 数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。
 *
 * 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
 * 题目数据保证答案是一个 32-bit 整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,4,6,8,10]
 * 输出：7
 * 解释：所有的等差子序列为：
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 * 示例 2：
 *
 * 输入：nums = [7,7,7,7,7]
 * 输出：16
 * 解释：数组中的任意子序列都是等差子序列。
 *
 *
 * 提示：
 *
 * 1  <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 */
public class _446_等差数列划分II_子序列 {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Map<Long, Integer>[] f = new Map[n];
        for (int i = 0; i < n; ++i) {
            f[i] = new HashMap<Long, Integer>();
        }
        // 对于每一个index都有一个map
        // key : 相同的d 第一次遇到会记录下来
        // 下一次扫描遇到就会累加到记录中，并且是2*n+1地累加（即：上一轮已经加过一次，这次要（先加一）再加一次）
        // 如： 1 2 3  sum = 1
        // 1 2 3 4    sum = 1+1+1 = 3
        // 1 2 3 4 5  sum = 3+3+1 = 7
        // 不断累加总数，双指针前移
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long d = 1L * nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                ans += cnt;
                f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return ans;
    }
}
