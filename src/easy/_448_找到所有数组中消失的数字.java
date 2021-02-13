package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * 难度
 * 简单
 *
 * 585
 *
 * 收藏
 *
 * 分享
 * 切换为英文
 * 接收动态
 * 反馈
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 */
public class _448_找到所有数组中消失的数字 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        /**
         * 1、首先，依次将目前数组中的数字对应的下标的对应的数字加n
         * 2、这时，如果某个位置上的数字没有加，那么这个下标对应的数字在数组中是不存在的
         * 3、比较返回即可
         */
        List<Integer> res = new ArrayList();
        int index = 0;
        for (int i = 0; i < nums.length; i++)
        {
            index = (nums[i] - 1) % nums.length;
            nums[index] += nums.length;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] <= nums.length)
            {
                res.add(i+1);
            }
        }
        return res;
    }
}
