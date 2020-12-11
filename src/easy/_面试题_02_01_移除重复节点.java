package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.01. 移除重复节点
 * 难度
 * 简单
 *
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 */
public class _面试题_02_01_移除重复节点 {
    /**
     * 解题思路：
     *      新建一个头结点，然后用set做容器进行筛选，把通过筛选的节点依次放入temp中，关键步骤就在if判断中
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        Set<Integer> set = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            //这里先拿到下一个节点，接下来为了将节点赋值给temp，需要将next置为空，
            // 所以先拿出来，之后就可以继续往下进行
            ListNode next = node.next;
            //如果set中不存在，将该节点放入temp中，并将数值放在set中做标记
            if (!set.contains(node.val)) {
                node.next = null;
                temp.next = node;
                temp = temp.next;
                set.add(node.val);
            }
            node = next;
        }
        return ans.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
