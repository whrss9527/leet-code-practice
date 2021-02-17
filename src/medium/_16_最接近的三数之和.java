package medium;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 难度
 * 中等
 *
 * 687
 *
 * 收藏
 *
 * 分享
 * 切换为英文
 * 接收动态
 * 反馈
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 */
public class _16_最接近的三数之和 {
    /**
     * 遍历数组，然后用双指针
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closeSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length-2; i++)
        {
            int l = i+1;
            int r = nums.length-1;
            while (l < r)
            {
                int newSum = nums[i] + nums[l] + nums[r];
                if (Math.abs(newSum - target) < Math.abs(closeSum - target))
                {
                    closeSum = newSum;
                }
                if (newSum > target)
                {
                    r--;
                }
                else if(newSum < target)
                {
                    l++;
                }
                else
                {
                    return target;
                }
            }
        }
        return closeSum;
    }
}
