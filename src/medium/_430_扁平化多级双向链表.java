package medium;

public class _430_扁平化多级双向链表 {
    /***
     * 注意 本题是双向链表，可以在遍历至尾部时接入另一个链表，形成一个整链表。返回时也可返回尾节点
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    public Node dfs(Node node) {
        Node cur = node;
        // 记录链表的最后一个节点
        Node last = null;

        while (cur != null) {
            // next 不停地向后刷，如果遇到当前节点有子节点时，将该节点记录，等到遍历完子节点后让子节点地尾节点指向该next
            Node next = cur.next;
            //  如果有子节点，那么首先处理子节点
            if (cur.child != null) {
                Node childLast = dfs(cur.child);

                next = cur.next;
                //  将 node 与 child 相连
                cur.next = cur.child;
                cur.child.prev = cur;

                //  如果 next 不为空，就将 last 与 next 相连
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }

                // 将 child 置为空
                cur.child = null;
                last = childLast;
            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }

}
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};