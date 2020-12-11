package difficulty;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *  
 *
 * 提示：
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _41_缺失的第一个正数 {
    /**
     * 解题思路：
     *      遍历一次数组把大于等于1的和小于数组大小的值放到原数组对应位置，
     *      然后再遍历一次数组查当前下标是否和值对应，如果不对应那这个下标就是答案，
     *      否则遍历完都没出现那么答案就是数组长度加1。
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //去重顺带将元素放到对应下标位置中
            while (0 < nums[i] && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        //然后从1开始往后找，找到第一个不相等就返回
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        //遍历完都没出现那么答案就是数组长度加1。
        return nums.length + 1;
    }
}
