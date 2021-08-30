package medium;

import java.util.Arrays;

public class _528_按权重随机选择 {
    int[] pre;
    int total;

    public _528_按权重随机选择(int[] w) {
        // 计算前缀和 即从0到i的元素的和放在位置i上
        pre = new int[w.length];
        pre[0] = w[0];
        for (int i = 1; i < w.length; ++i) {
            pre[i] = pre[i - 1] + w[i];
        }
        // 总份数（原数组和）
        total = Arrays.stream(w).sum();
    }

    public int pickIndex() {
        // 生成一个随机数
        int x = (int) (Math.random() * total) + 1;
        return binarySearch(x);
    }

    private int binarySearch(int x) {
        // 二分查找，寻找随机数应该存放的区间，不断缩小范围，返回low
        int low = 0, high = pre.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (pre[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
