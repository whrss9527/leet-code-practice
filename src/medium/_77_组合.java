package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _77_组合 {
    List<List<Integer>> result;
    List<Integer> tmp;

    /**
     * 解题思路：
     *      1、创建返回对象，创建返回对象中的子对象即[1,2]、[1，3][1，4]之类
     *      2、定义一个remain入参（初始为2，即每个元素只能存储2个数字），当remain等于0时，将该元素放入反参大对象中
     *      3、i <= n - k + 1 为终止执行for循环的条件，即第一个数为1到3，第二个数为第一个数+1到4。
     *      4、这样我们就能够依次将所有不同的元素加入到返回值中。
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<List<Integer>>();
        tmp = new ArrayList<Integer>();
        backTrace(k, 0, n);
        return result;
    }
    public void backTrace(int remain, int last, int n) {
        if(remain == 0) {
            result.add(new ArrayList(tmp));
            return;
        }
        // n-remain+1这里是剪枝的关键，25ms   到 1ms
        /*
        剪枝：终止条件为 i <= n - k + 1 而不是 i <= n
        原理：当前层的递归是找到 k 个元素，即我们这个 for 循环添加的是 k 个元素中的第一个元素
             然后再递归找剩下的 k - 1 个元素，如果我们添加的这第 1 个元素后，后面剩下的不足 k - 1 个元素，那么最终肯定是不满足条件的
             那么其实就无需进行递归，可以根据这个条件进行剪枝，即每次都预留后面的元素 大于等于 k - 1 个元素
        */
        for(int i=last+1; i<=n-remain+1; i++) {
            tmp.add(i);
            backTrace(remain-1, i, n);
            tmp.remove(tmp.size()-1);
        }
    }

}


