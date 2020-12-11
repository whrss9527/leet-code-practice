package medium;

import javafx.print.Printer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuhao
 * @date 2020/10/29 14:51
 * <p>
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * <p>
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * <p>
 * 计算从根到叶子节点生成的所有数字之和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 1
 * / \
 * 2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 * <p>
 * 输入: [4,9,0,5,1]
 * 4
 * / \
 * 9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _129_求根到叶子节点数字之和 {
    static int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        childSum(0,root);
        return sum;
    }

    private void childSum(int val,TreeNode root){
        //如果节点为空，直接返回，停止向下递归
        if(root==null) {return;}
        //计算该节点及以上若干个节点组合的数字
        int k = val*10+root.val;
        //直到二叉树末梢，将整个枝加在sum中
        if(root.left==null&&root.right==null){
            sum+=k;
        }
        //往左递归
        childSum(k,root.left);
        //往右递归
        childSum(k,root.right);
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    public static void main(String[] args) {
////        Map<String, Integer> map = new HashMap<>();
////        map.put("name", 1);
////        map.merge("name", 1, (oldValue, newValue) -> oldValue + newValue);
////        map.merge("count", 1, (oldValue, newValue) -> oldValue + newValue);
////        System.out.println(map);
//
//
//
//    }
    //抽象功能接口
    interface Printer {
        void print(String val);
    }
    //通过参数传递功能接口
    public void printSomething(String something, Printer printer) {
        printer.print(something);
    }
    //通过创建对象调用函数
    public static void main(String[] args) {


        _129_求根到叶子节点数字之和 demo = new _129_求根到叶子节点数字之和();
        String something="I am Lambda";
        //关注下面的这行代码
        demo.printSomething(something, toPrint -> System.out.println(toPrint));
    }
}
