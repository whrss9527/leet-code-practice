package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _18_四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //首先将数组排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        //如果数组不满足条件直接返回
        if (nums == null || nums.length < 4) {
            return result;
        }
        /*
        * 首先对两端的和进行比较，如果两端的和与结果背道而驰，直接返回
        * */
        int minValue = nums[0] + nums[1] + nums[2] + nums[3];
        int maxValue = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] + nums[nums.length - 4];

        if (minValue > target || maxValue < target) {
            return result;
        }
        //接下来对可能满足条件的数组进行计算

        /**
         * 使用两层for循环，共设置4个指针
         * 最左边一个，最右边一个，再往里面的左边加两个指针--->  0 0 0 * * * * * * * 0
         * 四个指针根据条件进行移动。第三个指针最开始移动，依次判断条件是否合适，然后是第二个和第四个，第一个
         */
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                minValue = nums[i] + nums[j] + nums[left] + nums[left + 1];
                maxValue = nums[i] + nums[j] + nums[right] + nums[right - 1];
                if (minValue > target || maxValue < target) {
                    continue;
                }
                while (left < right) {
                    int temp = nums[left] + nums[right] + nums[i] + nums[j];
                    if (temp == target) {
                        List<Integer> l = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        result.add(l);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (temp > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
