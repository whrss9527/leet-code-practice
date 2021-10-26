package easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class _496_下一个更大元素I {
    // 单调栈 + 哈希表
    //
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Deque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = nums2.length - 1; i >= 0; --i) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            // 如果栈中还存在元素 说明有比当前num值大的数，记录。没有则-1
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }

        // 遍历nums1 将nums2中记录的值搬过来，返回！
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
