package easy;

import java.util.*;

/**
 * @author wuhao
 * @date 2020/10/28 15:38
 *
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-number-of-occurrences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1207_独一无二出现的次数 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<>();
        //遍历数组
        for (int elem : arr) {
            //将数组中的元素作为key，个数作为value 放在map中
            //其中getOrDefault方法为jdk8新增方法，取map中元素，如果没有就设置默认值
            counter.put(elem, counter.getOrDefault(elem, 0) + 1);
        }
        //将map长度和去重后的map长度做对比，相同则为符合条件，返回true
        //其中Map.values()方法为拿到map中所有的value，返回集合
        List l  =  (List)counter.values();
        return counter.size() == new HashSet<Integer>(counter.values()).size();
    }

    public static void main(String[] args) {
        Map<String, Integer> counter = new HashMap<>();
        counter.put("1",1);
        counter.put("2",0);
        counter.put("3",2);
        counter.put("4",3);
        Collection<Integer> c = counter.values();
        c.forEach(ele -> System.out.println(ele));
    }
}
