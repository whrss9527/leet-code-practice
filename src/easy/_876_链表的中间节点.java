package easy;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *  
 *
 * 提示：
 *
 * 给定链表的结点数介于 1 和 100 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _876_链表的中间节点 {
    /**
     * 解题思路：
     *      本题主要考察对链表的基本理解
     *      这里采用一个链表常用的快慢指针的思想
     *      1、设定一个快指针（每次走两格），设定一个慢指针（每次走一格）。
     *      2、快指针指向结尾的时候，慢指针刚好指向链表的中间
     *      3、将慢指针所指向的节点返回
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        //设定一个快指针
        ListNode fast = head;
        //设定一个慢指针
        ListNode slow = head;

        while (fast != null && fast.next != null){
            //快指针走两步
            fast=fast.next.next;
            //慢指针走一步
            slow=slow.next;
        }
        //当节点数为1时，直接返回--无问题
        //当节点数为奇数个，例如3，fast指向第三个 slow指向第二个，此时再判断不满足条件，则返回solw，正确
        //当节点数为偶数个时，例如4，fast指向第三个，判断满足条件，再指向第五个，此时slow指向第三个，此时再判断不满足条件，则返回solw，正确
        return slow;
    }
}
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
