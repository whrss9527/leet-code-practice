package medium;

import java.util.Arrays;

/**
 *面试题 10.11. 峰与谷
 * 难度
 * 中等
 *
 * 在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。例如，在数组{5, 8, 6, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。
 *
 * 示例:
 *
 * 输入: [5, 3, 1, 2, 3]
 * 输出: [5, 1, 3, 2, 3]
 * 提示：
 *
 * nums.length <= 10000
 */
public class _面试题10_11_峰与谷 {
    /**
     * 先排序,然后尾头尾头...再组成新组,
     *
     * 原理如下:
     *
     * 设一个已排序数组[1,2,3,4,5,6],
     *
     * 左半边[1,2,3]每个数 都小于 右半边[4,5,6]每个数;
     *
     * 按[6,1][5,2] 这样排列,
     *
     * 每组第一个数都是属于右半边的
     *
     * ,每组第二个数都是属于左半边的
     *
     * 则不管怎么排,每组第一个数 都大于 其他组和自己组第二个数
     * @param nums
     */
    public static void wiggleSort(int[] nums) {
        if(nums==null||nums.length<3){
            return;
        }
        int len = nums.length;
        int res [] = new int[len];
        for(int i = 0;i<len;i++){
            res[i] = nums[i];
        }
        Arrays.sort(res);

        int left = 0;
        int right = len-1;
        while (left<right){

            nums[left*2] = res[right];
            nums[left*2+1]= res[left];
            right--;
            left++;
        }
        if (left==right){
            nums[left*2] = res[left];
            return;
        }

        for(int i = 0;i<nums.length;i++){
            System.out.println(nums[i]);
        }

    }

    public static void main(String[] args) {
        int nums[] = {3,5,2,1,6,4};
        wiggleSort(nums);
    }
}
