package medium;

import java.util.PriorityQueue;

public class _295_数据流的中位数 {
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public _295_数据流的中位数() {
        // 带有自动排序的队列
        queMin = new PriorityQueue<Integer>((a, b) -> (b - a)); // b > a  从大到小 降序
        queMax = new PriorityQueue<Integer>((a, b) -> (a - b)); // b < a  从小到大 升序
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            // 保证queMin.size = queMax.size+1 || queMin.size = queMax.size
            // 如果有一边超过了本来应该承载的size，就匀到另一边。
            if (queMax.size() + 1 < queMin.size()) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        // 如果queMin的承载数量大于queMax，说明中位数在queMin的队列头部，直接拿到返回
        // 如果两个size相等，则拿到两个队列头/2返回
        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        }
        return (queMin.peek() + queMax.peek()) / 2.0;
    }
}

