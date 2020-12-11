package easy;

/**
 * 53. 最大子序和
 * 难度
 * 简单
 *
 * 1972
 *
 * 收藏
 *
 * 分享
 * 切换为英文
 * 关注
 * 反馈
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 通过次数236,651提交次数463,450
 */
public class _53_最大子序和 {
    /**
     * 解题思路：
     *          将数组遍历，从头到尾的顺序。
     *          从第一个数字开始累加，如果和为正数，则不断地和上一个数进行比较，
     *          若和变成了负数，则和要从新计算，然后和之前计算出的最大的和进行比较。
     *          最后将和返回
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for(int num : nums){
            if(sum>0){
                sum+=num;
            }else{
                sum=num;
            }
            res = Math.max(res,sum);
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
