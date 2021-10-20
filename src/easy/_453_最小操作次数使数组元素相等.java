package easy;

import java.util.Arrays;

public class _453_最小操作次数使数组元素相等 {
    /***
     * 1. 拿到数组中的最小值
     * 2. 然后我也看不懂了。
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - minNum;
        }
        return res;
    }

}
