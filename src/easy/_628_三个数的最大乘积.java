package easy;

import java.util.Arrays;

/**
 * @author wuhao
 * @date 2021/1/20 10:28
 *
 *
 * 628. 三个数的最大乘积
 * 难度
 * 简单
 *
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 *
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 */
public class _628_三个数的最大乘积 {
    //排序之后最大乘积就两种情况：
    // 1、如果全是正数就是最后三个数相乘
    // 2、如果有负数最大的乘机要么是最后三个数相乘，要么是两个最小的负数相乘再乘以最大的正数
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[0]*nums[1]*nums[len-1],nums[len-1]*nums[len-2]*nums[len-3]);
    }
}
