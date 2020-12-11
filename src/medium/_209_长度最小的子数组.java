package medium;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _209_长度最小的子数组 {
    /**
     * 解题思路：
     *      使用两个指针 i j 一个指向开始位置（j），一个指向前面（i）。
     *      当符合条件之后，先移动指针j，然后将之前计算的和调整，删除之前的元素
     *      然后再移动指针i，知道符合条件，每次将最小的len记录。
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int len = 0;
        int j = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            while (sum>=s){
                //len ==0 的话说明是第一次sum>=s , 所以为i-j+1 当第二次碰到，则为每次中最小的长度
                len = len==0 ? i-j+1 : Math.min(len,i-j+1);
                sum-=nums[j++];
            }
        }
        return len;
    }
}
