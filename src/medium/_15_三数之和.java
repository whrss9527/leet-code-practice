package medium;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

 注意：答案中不可以包含重复的三元组。



 示例：

 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class _15_三数之和 {
    /**
     * 解题思路：
     *        首先要理解题意：1、要求从数组中取出符合条件的三个数字
     *                       2、不能有重复的答案->不是下标重复，是元素重复，无论顺序，比如 [1，3，-4] [1,-4,3]是一样的，属于重复答案
     *        然后我们开始想如何解题
     *                       1、这道题取出三个符合条件的数是没有难度的，遍历相等即可，难度在于不重复，这也是我上面标红的原因
     *                       2、不重复不代表需要直接去重，这样的话 [-1，-1，2]就不会出现在你的结果集中了
     *                       3、去重首先就是需要为数组排序，排序之后，相同的数就会相邻，这样我们在判断的时候就可以进行相应的忽略即去重
     *                       4、接下来请认真的看代码，我为每一行都进行了解释，有不理解欢迎留言
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        //调用数组排序（按从小到大排序）
        Arrays.sort(nums);
        //定义一个list，用来包装返回值
        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案
                //定义一个l，用来标记第二个数的下标
                // r是第二个数的最大值，初始为数组的最后一个元素的下标
                // 定义一个sum，这样接下来计算就会省很多步
                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        //如果符合情况，则添加在返回值中
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        //然后继续判断，是否有元素重复
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        //如果 nums[l] + nums[r] + num[i] < 0 则说明当前数字相加之和还不够大，需要将指针往后移动
                        // 则前面的指针往后移动一位 遇到重复的跳过
                        while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值
                        l++;
                    } else {
                        //如果 nums[l] + nums[r] + num[i] > 0 则说明当前数字相加之和过大，后面的元素已经不满足条件，
                        // 则后面的指针往前移动一位 遇到重复的跳过
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
        return ls;
    }


    public static void main(String[] args) {
        int num[] = {1,-5,4,4,-5,4,-1};

        System.out.println(threeSum(num).toString());
    }
}
