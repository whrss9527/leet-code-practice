package medium;

public class _45_跳跃游戏2 {
    public int jump(int[] nums) {
        // 拿到最后一个位置的索引
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                // 退着走， 从前面找到后面，找到下标最小的一个元素可以到现在这步， 就加，保证这一步是从后往前走步子迈得最大
                if (i + nums[i] >= position) {

                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
