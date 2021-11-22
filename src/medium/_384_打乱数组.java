package medium;

import java.util.Random;

public class _384_打乱数组 {
    // 存原来的数组
    int[] nums;
    // 存数组长度
    int n;
    Random random = new Random();
    public _384_打乱数组(int[] _nums) {
        nums = _nums;
        n = nums.length;
    }
    public int[] reset() {
        return nums;
    }
    public int[] shuffle() {
        int[] ans = nums.clone();
        for (int i = 0; i < n; i++) {
            swap(ans, i, i + random.nextInt(n - i));
        }
        return ans;
    }
    // 交换方法
    void swap(int[] arr, int i, int j) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

}
